package com.redstack.ProfileServer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
public class ProfileController {

    List<Map<String, Object>> feedbackList = new ArrayList<>();
    int nextId = 1;


    @PostMapping("/feedback")
    public Map<String, Object> createFeedback(@RequestBody Map<String, String> body) {

        Map<String, Object> feedback = new HashMap<>();

        feedback.put("id", nextId++);
        feedback.put("name", body.get("name"));
        feedback.put("message", body.get("message"));

        feedbackList.add(feedback);

        return feedback;
    }


    @GetMapping("/feedback")
    public List<Map<String, Object>> getFeedback() {

        return feedbackList;
    }


    @PutMapping("/feedback/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable int id, @RequestBody Map<String, String> body) {

        for (Map<String, Object> feedback : feedbackList) {

            if (feedback.get("id").equals(id)) {

                feedback.put("message", body.get("message"));

                return ResponseEntity.ok(feedback);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id) {

        boolean removed = feedbackList.removeIf(feedback -> feedback.get("id").equals(id));

        if (removed) {
            return ResponseEntity.ok(Map.of("message", "Feedback deleted"));
        }

        return ResponseEntity.notFound().build();
    }
}