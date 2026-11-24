package com.redstack.employeeApi.Controllers;

import com.redstack.employeeApi.Customer;
import com.redstack.employeeApi.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    //to store the feedback in memory
    public static List<Feedback> feedbacks = new ArrayList<>();

    //Check if a customer exists. Compares as text, so a bad id never crashes the server.
    private boolean customerExists(String customerId) {
        for (Customer customer : CustomerController.customers) {
            if (String.valueOf(customer.getId()).equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    //GET ALL FEEDBACK
    @GetMapping
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    //GET ONE FEEDBACK
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int id) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getId() == id) {
                return ResponseEntity.ok(feedback);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Feedback not found"));
    }

    //POST - Add feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
        if (!customerExists(feedback.getCustomerId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Customer not found"));
        }
        feedbacks.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    //PUT - Update feedback
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {

        // Find the existing feedback
        Feedback foundFeedback = null;
        for (Feedback feedback1 : feedbacks) {
            if (feedback1.getId() == id) {
                foundFeedback = feedback1;
                break;
            }
        }

        // Check if feedback exists
        if (foundFeedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Feedback not found"));
        }

        // Check if the customer exists
        if (!customerExists(feedback.getCustomerId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Customer not found"));
        }

        // Update the existing feedback
        foundFeedback.setMessage(feedback.getMessage());
        foundFeedback.setCustomerId(feedback.getCustomerId());

        return ResponseEntity.ok(foundFeedback);
    }

    //DELETE a feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id) {
        Feedback foundFeedback = null;
        for (Feedback feedback : feedbacks) {
            if (feedback.getId() == id) {
                foundFeedback = feedback;
                break;
            }
        }
        if (foundFeedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Feedback not found"));
        }
        feedbacks.remove(foundFeedback);
        return ResponseEntity.ok(Map.of("message", "Feedback deleted"));
    }
}