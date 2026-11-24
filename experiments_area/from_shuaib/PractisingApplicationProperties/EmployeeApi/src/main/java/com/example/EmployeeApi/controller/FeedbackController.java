package com.example.EmployeeApi.controller;

import com.example.EmployeeApi.model.Feedback;
import com.example.EmployeeApi.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }
}