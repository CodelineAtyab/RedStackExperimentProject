package com.CRUD.EmployeesCRUD.controller;

import com.CRUD.EmployeesCRUD.model.Customer;
import com.CRUD.EmployeesCRUD.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    public static List<Feedback> feedbackList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
        Customer foundCustomer = CustomerController.customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(feedback.getCustomerId());
        }).findFirst().orElse(null);

        if (foundCustomer == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        feedbackList.add(feedback);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable String id) {
        Feedback foundFeedback = feedbackList.stream().filter((currFeedback) -> {
            return currFeedback.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundFeedback != null) {
            return ResponseEntity.ok(foundFeedback);
        }

        return ResponseEntity.status(404).body("Feedback not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updateFeedback) {

        Feedback foundFeedback = feedbackList.stream().filter((currFeedback) -> {
            return currFeedback.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundFeedback == null) {
            return ResponseEntity.status(404).body("Feedback not found");
        }

        Customer foundCustomer = CustomerController.customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(updateFeedback.getCustomerId());
        }).findFirst().orElse(null);

        if (foundCustomer == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        foundFeedback.setMessage(updateFeedback.getMessage());
        foundFeedback.setCustomerId(updateFeedback.getCustomerId());
        return ResponseEntity.ok(foundFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {
        Feedback foundFeedback = feedbackList.stream().filter((currFeedback) -> {
            return currFeedback.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundFeedback != null) {
            feedbackList.remove(foundFeedback);
            return ResponseEntity.ok("Feedback deleted");
        }

        return ResponseEntity.status(404).body("Feedback not found");
    }
}