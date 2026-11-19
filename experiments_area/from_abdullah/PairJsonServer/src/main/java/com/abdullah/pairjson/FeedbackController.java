package com.abdullah.pairjson;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FeedbackController {
    private ArrayList<Feedback> feedbackList = new ArrayList<>();
    private int nextId = 1;

    @PostMapping("/feedback")
    public synchronized ResponseEntity<Feedback> addFeedback(@RequestBody Feedback request) {
        Feedback feedback = new Feedback();
        feedback.setId(nextId);
        feedback.setName(request.getName());
        feedback.setMessage(request.getMessage());
        nextId++;
        feedbackList.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    @GetMapping("/feedback")
    public synchronized ArrayList<Feedback> getFeedback() {
        return new ArrayList<>(feedbackList);
    }

    @PutMapping("/feedback/{id}")
    public synchronized Feedback updateFeedback(@PathVariable("id") int id,
                                                @RequestBody Feedback request) {
        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback feedback = feedbackList.get(i);
            if (feedback.getId() == id) {
                feedback.setMessage(request.getMessage());
                return feedback;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");
    }

    @DeleteMapping("/feedback/{id}")
    public synchronized HashMap<String, Integer> deleteFeedback(@PathVariable("id") int id) {
        for (int i = 0; i < feedbackList.size(); i++) {
            if (feedbackList.get(i).getId() == id) {
                feedbackList.remove(i);
                HashMap<String, Integer> result = new HashMap<>();
                result.put("deleted", id);
                return result;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");
    }
}
