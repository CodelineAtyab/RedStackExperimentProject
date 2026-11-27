package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Feedback;
import com.noor.employeesapi.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id) {

        Feedback feedback = feedbackService.getFeedbackById(id);

        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {

        return ResponseEntity.status(201)
                .body(feedbackService.addFeedback(feedback));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updated) {

        Feedback feedback = feedbackService.updateFeedback(id, updated);

        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {

        if (feedbackService.deleteFeedback(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCustomer(
            @PathVariable String customerId) {

        return ResponseEntity.ok(
                feedbackService.getFeedbackByCustomer(customerId));
    }
}