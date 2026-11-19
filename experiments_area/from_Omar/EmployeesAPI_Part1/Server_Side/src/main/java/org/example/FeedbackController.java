package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final Datastore store;

    public FeedbackController(Datastore store) {
        this.store = store;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return store.getFeedbackList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id) {
        Feedback feedback = store.getFeedbackList().stream()
                .filter(f -> f.id().equals(id))
                .findFirst()
                .orElse(null);

        if (feedback == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(feedback);
    }

    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        boolean customerExists = store.getCustomers().stream()
                .anyMatch(c -> c.id().equals(feedback.customerId()));

        if (!customerExists) {
            return ResponseEntity.status(400)
                    .body("Bad Request: Cannot create feedback. Customer ID '" + feedback.customerId() + "' does not exist.");
        }

        store.getFeedbackList().add(feedback);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable String id, @RequestBody Feedback incoming) {
        boolean customerExists = store.getCustomers().stream()
                .anyMatch(c -> c.id().equals(incoming.customerId()));

        if (!customerExists) {
            return ResponseEntity.status(400)
                    .body("Bad Request: Associated Customer ID does not exist.");
        }

        List<Feedback> list = store.getFeedbackList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id().equals(id)) {
                Feedback updated = new Feedback(id, incoming.message(), incoming.customerId());
                list.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id) {
        boolean removed = store.getFeedbackList().removeIf(f -> f.id().equals(id));
        if (!removed) {
            return ResponseEntity.status(404).body("Feedback with ID " + id + " not found.");
        }
        return ResponseEntity.ok("Successfully deleted feedback with ID: " + id);
    }
}