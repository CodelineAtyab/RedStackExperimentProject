package com.redstack.feedbacklinkedtocustomer.controller;

import com.redstack.feedbacklinkedtocustomer.model.Feedback;
import com.redstack.feedbacklinkedtocustomer.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    // Get all feedback
    @GetMapping
    public ResponseEntity<ArrayList<Feedback>> getAllFeedback() {

        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String id) {

        Feedback feedback = feedbackService.getFeedbackById(id);

        if (feedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback " + id + " not found");
        }

        return ResponseEntity.ok(feedback);
    }

    // Add feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedbackToAdd) {

        try {
            Feedback createdFeedback = feedbackService.addFeedback(feedbackToAdd);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdFeedback);

        } catch (IllegalArgumentException exception) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

}
