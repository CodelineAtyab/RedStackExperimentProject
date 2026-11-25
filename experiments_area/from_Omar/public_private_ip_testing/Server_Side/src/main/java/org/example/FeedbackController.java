package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String id) {
        Optional<Feedback> found = feedbackService.findById(id);
        if (found.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback " + id + " not found");
        }
        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        Optional<Feedback> created = feedbackService.create(feedback);
        if (created.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer " + feedback.customerId() + " not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(created.get());
    }
}