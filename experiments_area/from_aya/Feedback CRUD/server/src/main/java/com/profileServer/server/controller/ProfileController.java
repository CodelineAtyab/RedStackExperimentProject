package com.profileServer.server.controller;

import com.profileServer.server.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class ProfileController {

    private List<Feedback> feedbackList = new ArrayList<>();

    private int nextId = 1;


    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Map<String, String> data) {

        String name = data.get("name");
        String message = data.get("message");

        Feedback feedback = new Feedback(nextId, name, message);

        nextId++;

        feedbackList.add(feedback);

        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }


    @GetMapping
    public List<Feedback> getAllFeedback() {

        return feedbackList;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable int id,
            @RequestBody Map<String, String> updateData) {

        for (Feedback feedback : feedbackList) {

            if (feedback.getId() == id) {

                feedback.setMessage(updateData.get("message"));

                return ResponseEntity.ok(feedback);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Feedback not found"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id) {

        for (Feedback feedback : feedbackList) {

            if (feedback.getId() == id) {

                feedbackList.remove(feedback);

                return ResponseEntity.ok(feedback);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Feedback not found"));
    }
}
