package com.redstack.LinkingFeedbackCustomer.controller;

import java.util.ArrayList;
import java.util.Map;

import com.redstack.LinkingFeedbackCustomer.model.Customer;
import com.redstack.LinkingFeedbackCustomer.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    ArrayList<Feedback> feedbackList = CustomerController.feedbackList;

    // Get all feedback
    @GetMapping
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

    // Get one feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String id) {

        for (Feedback currFeedback : feedbackList) {

            if (currFeedback.id.equals(id)) {
                return ResponseEntity.ok(currFeedback);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Feedback not found!"));
    }

    // Add feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback newFeedback) {

        boolean customerExists = false;

        for (Customer currCustomer : CustomerController.customersList) {

            if (currCustomer.id.equals(newFeedback.customerId)) {
                customerExists = true;
                break;
            }
        }

        if (!customerExists) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "refused (no such customer)"));
        }

        feedbackList.add(newFeedback);

        return ResponseEntity.ok(newFeedback);
    }

    // Update feedback
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updatedFeedback) {

        for (Feedback currFeedback : feedbackList) {

            if (currFeedback.id.equals(id)) {

                boolean customerExists = false;

                for (Customer currCustomer : CustomerController.customersList) {

                    if (currCustomer.id.equals(updatedFeedback.customerId)) {
                        customerExists = true;
                        break;
                    }
                }

                if (!customerExists) {
                    return ResponseEntity.badRequest()
                            .body(Map.of("message", "Customer does not exist!"));
                }

                currFeedback.message = updatedFeedback.message;
                currFeedback.customerId = updatedFeedback.customerId;

                return ResponseEntity.ok(currFeedback);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Feedback not found!"));
    }

    // Delete feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {

        Feedback foundFeedback = null;

        for (Feedback currFeedback : feedbackList) {

            if (currFeedback.id.equals(id)) {
                foundFeedback = currFeedback;
                break;
            }
        }

        if (foundFeedback != null) {

            feedbackList.remove(foundFeedback);

            return ResponseEntity.ok(
                    Map.of("message", "Feedback deleted successfully!")
            );
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Feedback not found!"));
    }
}






