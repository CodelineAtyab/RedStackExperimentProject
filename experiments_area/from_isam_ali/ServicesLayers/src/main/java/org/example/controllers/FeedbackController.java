package org.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    public static final List<Feedback> feedbackList = new ArrayList<>();

    // POST /feedback
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Feedback feedback) {
        if (CustomerController.findCustomer(feedback.getCustomerId()) == null) {
            return unknownCustomer(feedback.getCustomerId());
        }
        feedbackList.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    // GET /feedback
    @GetMapping
    public List<Feedback> getAll() {
        return feedbackList;
    }

    // GET /feedback/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Feedback found = null;
        for (Feedback f : feedbackList) {
            if (f.getId().equals(id)) {
                found = f;
                break;
            }
        }
        if (found == null) {
            return notFound(id);
        }
        return ResponseEntity.ok(found);
    }

    // PUT /feedback/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Feedback updated) {
        if (CustomerController.findCustomer(updated.getCustomerId()) == null) {
            return unknownCustomer(updated.getCustomerId());
        }
        for (int i = 0; i < feedbackList.size(); i++) {
            if (feedbackList.get(i).getId().equals(id)) {
                updated.setId(id);
                feedbackList.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return notFound(id);
    }

    // DELETE /feedback/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean removed = feedbackList.removeIf(f -> f.getId().equals(id));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Feedback " + id + " was removed."));
    }

    private ResponseEntity<?> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "No feedback with id " + id + " exists."));
    }

    private ResponseEntity<?> unknownCustomer(String customerId) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Refused: no customer with id " + customerId + " exists."));
    }
}