package com.CustomerCustomerFeedbackAPI.Customer.controller;
import com.CustomerCustomerFeedbackAPI.Customer.model.Customer;
import com.CustomerCustomerFeedbackAPI.Customer.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    static List<Feedback> feedbacks = new ArrayList<>();

    // POST
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {

        boolean customerFound = false;

        for (Customer customer : CustomerController.customers) {
            if (customer.getId().equals(feedback.getCustomerId())) {
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            return new ResponseEntity<>("Customer not found", HttpStatus.BAD_REQUEST);
        }

        feedbacks.add(feedback);
        return new ResponseEntity<>(feedback, HttpStatus.CREATED);
    }

    // GET all feedback
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbacks;
    }

    // GET feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable String id) {

        for (Feedback feedback : feedbacks) {
            if (feedback.getId().equals(id)) {
                return new ResponseEntity<>(feedback, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Feedback not found", HttpStatus.NOT_FOUND);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updatedFeedback) {

        boolean customerFound = false;

        for (Customer customer : CustomerController.customers) {
            if (customer.getId().equals(updatedFeedback.getCustomerId())) {
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            return new ResponseEntity<>("Customer not found", HttpStatus.BAD_REQUEST);
        }

        for (Feedback feedback : feedbacks) {
            if (feedback.getId().equals(id)) {
                feedback.setMessage(updatedFeedback.getMessage());
                feedback.setCustomerId(updatedFeedback.getCustomerId());

                return new ResponseEntity<>(feedback, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Feedback not found", HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {

        for (int i = 0; i < feedbacks.size(); i++) {
            if (feedbacks.get(i).getId().equals(id)) {
                feedbacks.remove(i);

                return new ResponseEntity<>(
                        "Removed",
                        HttpStatus.OK
                );
            }
        }

        return new ResponseEntity<>("Feedback not found", HttpStatus.NOT_FOUND);
    }
}
