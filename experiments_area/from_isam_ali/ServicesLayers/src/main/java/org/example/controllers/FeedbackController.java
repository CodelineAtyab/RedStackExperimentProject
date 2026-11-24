package org.example.controllers;

import java.util.List;
import java.util.Optional;

import org.example.Feedback;
import org.example.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // 201 Created, or 400 Bad Request when the customerId does not exist
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Feedback feedback) {
        if (!feedbackService.customerExists(feedback.getCustomerId())) {
            return unknownCustomer(feedback.getCustomerId());
        }
        Feedback created = feedbackService.create(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {
        return ResponseEntity.ok(feedbackService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Optional<Feedback> found = feedbackService.getOne(id);
        if (found.isPresent()) {
            return ResponseEntity.ok(found.get());
        }
        return notFound(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Feedback updated) {
        if (!feedbackService.customerExists(updated.getCustomerId())) {
            return unknownCustomer(updated.getCustomerId());
        }
        Optional<Feedback> result = feedbackService.update(id, updated);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return notFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        if (feedbackService.deleteOne(id)) {
            return ResponseEntity.ok("Feedback " + id + " deleted");
        }
        return notFound(id);
    }

    private ResponseEntity<String> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback " + id + " not found");
    }

    private ResponseEntity<String> unknownCustomer(String customerId) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Refused: no customer with id " + customerId + " exists");
    }
}
