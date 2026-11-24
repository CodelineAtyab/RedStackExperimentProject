package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.model.Feedback;
import com.redstack.EmployeesApi.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);

        if (feedback.isEmpty()) {
            return feedbackNotFound(id);
        }

        return ResponseEntity.ok(feedback.get());
    }

    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        Optional<Feedback> created = feedbackService.createFeedback(feedback);

        if (created.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Customer " + feedback.customerId + " does not exist"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(created.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id, @RequestBody Feedback replacement) {

        Optional<Feedback> updated = feedbackService.updateFeedback(id, replacement);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        }

        if (feedbackService.getFeedbackById(id).isEmpty()) {
            return feedbackNotFound(id);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Customer " + replacement.customerId + " does not exist"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {
        Optional<Feedback> deleted = feedbackService.deleteFeedback(id);

        if (deleted.isEmpty()) {
            return feedbackNotFound(id);
        }

        return ResponseEntity.ok(Map.of("message", "Feedback " + id + " deleted"));
    }

    private ResponseEntity<Map<String, String>> feedbackNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Feedback " + id + " not found"));
    }
}
