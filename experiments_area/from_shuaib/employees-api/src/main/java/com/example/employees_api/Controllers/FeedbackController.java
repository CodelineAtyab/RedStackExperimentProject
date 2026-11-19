package com.example.employees_api.Controllers;

import com.example.employees_api.Models.Feedback;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final CustomerController customerController;

    public FeedbackController(@Lazy CustomerController customerController) {
        this.customerController = customerController;
    }

    public List<Feedback> getFeedbackByCustomerId(String customerId) {
        return feedbackList.stream()
                .filter(f -> customerId.equals(f.getCustomerId()))
                .collect(Collectors.toList());
    }

    public int deleteFeedbackByCustomerId(String customerId) {
        int before = feedbackList.size();
        feedbackList.removeIf(f -> customerId.equals(f.getCustomerId()));
        return before - feedbackList.size();
    }

    @PostMapping
    public ResponseEntity<Object> createFeedback(@RequestBody Feedback feedback) {
        if (!customerController.customerExists(feedback.getCustomerId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Cannot create feedback: customerId '" + feedback.getCustomerId() + "' does not exist.");
        }
        feedbackList.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFeedbackById(@PathVariable String id) {
        Optional<Feedback> match = feedbackList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (match.isPresent()) {
            return ResponseEntity.ok(match.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Feedback with id '" + id + "' not found.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFeedback(@PathVariable String id, @RequestBody Feedback updatedFeedback) {
        Optional<Feedback> match = feedbackList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (match.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback with id '" + id + "' not found for update.");
        }

        String targetCustomerId = updatedFeedback.getCustomerId() != null
                ? updatedFeedback.getCustomerId()
                : match.get().getCustomerId();

        if (!customerController.customerExists(targetCustomerId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Cannot update feedback: customerId '" + targetCustomerId + "' does not exist.");
        }

        Feedback existing = match.get();
        existing.setMessage(updatedFeedback.getMessage());
        existing.setCustomerId(targetCustomerId);
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id) {
        boolean removed = feedbackList.removeIf(f -> f.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("Feedback with id '" + id + "' removed.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Feedback with id '" + id + "' not found for deletion.");
    }
}