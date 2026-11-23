package com.reddesk.desk_api.controller;

import com.reddesk.desk_api.model.Feedback;
import com.reddesk.desk_api.Service.FeedbackService;
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

    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {

        try {
            Feedback savedFeedback = feedbackService.addFeedback(feedback);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedFeedback);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String id) {

        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
