package com.redstack.employeeApi.Controllers;


import com.redstack.employeeApi.Feedback;
import com.redstack.employeeApi.services.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    //GET ALL FEEDBACK
    @GetMapping
    public ResponseEntity<?> getFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getFeedbacks();

        if (feedbacks.isEmpty()) {
            return ResponseEntity.ok("No feedback found");
        }

        return ResponseEntity.ok(feedbacks);
    }

    //GET ONE FEEDBACK
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int id) {
        Feedback feedback = feedbackService.getFeedbackById(id);

        if (feedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback with id " + id + " not found");
        }

        return ResponseEntity.ok(feedback);
    }

    //POST - Add feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
        boolean added = feedbackService.addFeedback(feedback);
        if (!added) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id " + feedback.getCustomerId() + " not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Feedback created");
    }

    //PUT - Update feedback
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable int id,
            @RequestBody Feedback feedback) {
        boolean updated = feedbackService.updateFeedback(id, feedback);
        if (!updated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback or customer not found");
        }
        return ResponseEntity.ok("Feedback updated");
    }

    //DELETE a feedback BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id) {
        boolean deleted = feedbackService.deleteFeedback(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback with id " + id + " not found");
        }

        return ResponseEntity.ok("Feedback deleted");
    }
}