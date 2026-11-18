package com.example.demoApplication.Controllers;

import com.example.demoApplication.Models.Feedback;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Feedback> getAllFeedbacks(){
        return feedbackList;
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback newFeedback){
        newFeedback.setId(nextId++);
        feedbackList.add(newFeedback);
        return newFeedback;
    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        Optional<Feedback> optionalFeedback = feedbackList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (optionalFeedback.isPresent()) {
            Feedback feedback = optionalFeedback.get();
            feedback.setMessage(updatedFeedback.getMessage());
            if (updatedFeedback.getName() != null) {
                feedback.setName(updatedFeedback.getName());
            }
            return feedback;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        boolean deleted = feedbackList.removeIf(f -> f.getId().equals(id));
        if (deleted) {
            return "Successfully deleted feedback with ID: " + id;
        }
        return "Feedback with ID " + id + " not found.";
    }

}


