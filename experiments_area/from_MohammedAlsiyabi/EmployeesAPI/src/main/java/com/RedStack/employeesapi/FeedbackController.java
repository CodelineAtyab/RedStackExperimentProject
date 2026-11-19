package com.teamred.employees;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    // Create (refuses an unknown customerId with 400)
    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        if (!customerExists(feedback.getCustomerId())) {
            return unknownCustomer(feedback.getCustomerId());
        }
        DataStore.feedbacks.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    // Read all
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return DataStore.feedbacks;
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable String id) {
        Optional<Feedback> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        return ResponseEntity.ok(found.get());
    }

    // Update (the new customerId must also exist)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable String id, @RequestBody Feedback updated) {
        Optional<Feedback> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        if (!customerExists(updated.getCustomerId())) {
            return unknownCustomer(updated.getCustomerId());
        }
        int index = DataStore.feedbacks.indexOf(found.get());
        updated.setId(id);
        DataStore.feedbacks.set(index, updated);
        return ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {
        boolean removed = DataStore.feedbacks.removeIf(f -> id.equals(f.getId()));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Feedback with id " + id + " was deleted"));
    }

    // ---- helpers ----

    private Optional<Feedback> findById(String id) {
        return DataStore.feedbacks.stream()
                .filter(f -> f.getId() != null && f.getId().equals(id))
                .findFirst();
    }

    private boolean customerExists(String customerId) {
        return customerId != null && DataStore.customers.stream()
                .anyMatch(c -> customerId.equals(c.getId()));
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Feedback with id " + id + " not found"));
    }

    private ResponseEntity<Map<String, String>> unknownCustomer(String customerId) {
        return ResponseEntity.badRequest()
                .body(Map.of("message", "Customer with id " + customerId + " does not exist, feedback not saved"));
    }
}
