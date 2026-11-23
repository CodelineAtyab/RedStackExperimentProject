package com.redstack.feedbackcrudcustomerlink.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redstack.feedbackcrudcustomerlink.model.Feedback;
import com.redstack.feedbackcrudcustomerlink.service.FeedbackService;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<?> getSpecificFeedback(@PathVariable String id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        if (feedback.isPresent()) {
            return ResponseEntity.ok(feedback.get());
        }
        return feedbackNotFound(id);
    }

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.createFeedback(feedback));
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable String id, @RequestBody Feedback request) {
        Optional<Feedback> updated = feedbackService.updateFeedback(id, request);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        }
        return feedbackNotFound(id);
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id) {
        if (feedbackService.deleteFeedback(id)) {
            return ResponseEntity.ok("Feedback deleted: id=" + id);
        }
        return feedbackNotFound(id);
    }

    @DeleteMapping("/feedback")
    public ResponseEntity<String> deleteAllFeedback() {
        feedbackService.deleteAllFeedback();
        return ResponseEntity.ok("All feedback deleted");
    }

    @GetMapping("/customers/{id}/feedback")
    public ResponseEntity<?> getFeedbackByCustomer(@PathVariable String id) {
        return ResponseEntity.ok(feedbackService.getFeedbackByCustomerId(id));
    }

    private ResponseEntity<String> feedbackNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback not found: id=" + id);
    }
}
