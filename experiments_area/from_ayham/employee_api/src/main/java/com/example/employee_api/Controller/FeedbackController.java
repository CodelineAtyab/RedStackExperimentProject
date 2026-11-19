package com.example.employee_api.Controller;

import java.util.List;

import com.example.employee_api.FeedbackService;
import com.example.employee_api.Model.Feedback;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable String id) {
        return feedbackService.findById(id);
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback newFeedback) {
        return feedbackService.create(newFeedback);
    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable String id, @RequestBody Feedback updatedFeedback) {
        return feedbackService.update(id, updatedFeedback);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable String id) {
        feedbackService.delete(id);
        return "Feedback with ID " + id + " has been deleted.";
    }
}
