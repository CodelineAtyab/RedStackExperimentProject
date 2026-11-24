package com.abdullah.employees;

import com.abdullah.employees.service.FeedbackService;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> addFeedback(
            @RequestBody Feedback feedback) {

        return ResponseEntity.status(201)
                .body(feedbackService.addFeedback(feedback));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedback(
            @PathVariable("id") String id) {

        return ResponseEntity.ok(feedbackService.getFeedback(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable("id") String id,
            @RequestBody Feedback feedback) {

        return ResponseEntity.ok(
                feedbackService.updateFeedback(id, feedback));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteFeedback(
            @PathVariable("id") String id) {

        return ResponseEntity.ok(feedbackService.deleteFeedback(id));
    }
}
