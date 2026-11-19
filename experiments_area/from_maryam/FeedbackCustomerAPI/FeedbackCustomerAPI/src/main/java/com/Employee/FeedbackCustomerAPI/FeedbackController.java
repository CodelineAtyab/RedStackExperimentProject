
package com.Employee.FeedbackCustomerAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    public static List<Feedback> feedbacks = new ArrayList<>();

    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {

        // check if the customer id in the feedback exists in the customers list.
        // return true if a matching customer is found, otherwise return false.
        boolean customerExists = CustomerController.customers.stream().anyMatch((currCustomer) -> {
            return currCustomer.getId().equals(feedback.getCustomerId());
        });

        if (!customerExists) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

        feedbacks.add(feedback);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbacks;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable String id) {

        // Search for feedback by its id
        // Filter the feedback list to find a matching id
        // Return the first matching feedback
        // If no feedback is found and return null
        // filter the list and keep only the items that match the given condition.
        Feedback foundFeedback = feedbacks.stream().filter((currFeedback) -> {
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

        Feedback foundFeedback = feedbacks.stream().filter((currFeedback) -> {
            return currFeedback.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundFeedback != null) {

            boolean customerExists = CustomerController.customers.stream().anyMatch((currCustomer) -> {
                return currCustomer.getId().equals(updateFeedback.getCustomerId());
            });

            if (!customerExists) {
                return ResponseEntity.badRequest().body("Customer not found");
            }

            foundFeedback.setMessage(updateFeedback.getMessage());
            foundFeedback.setCustomerId(updateFeedback.getCustomerId());

            return ResponseEntity.ok(foundFeedback);
        }

        return ResponseEntity.status(404).body("Feedback not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {

        Feedback foundFeedback = feedbacks.stream().filter((currFeedback) -> {
            return currFeedback.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundFeedback != null) {
            feedbacks.remove(foundFeedback);
            return ResponseEntity.ok("Feedback deleted");
        }

        return ResponseEntity.status(404).body("Feedback not found");
    }
}
