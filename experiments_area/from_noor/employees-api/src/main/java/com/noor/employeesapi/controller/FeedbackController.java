
package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Customer;
import com.noor.employeesapi.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final CustomerController customerController;

    public FeedbackController(CustomerController customerController) {
        this.customerController = customerController;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                return ResponseEntity.ok(feedback);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {

        ResponseEntity<Customer> customer =
                customerController.getCustomerById(feedback.getCustomerId());

        if (!customer.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }

        for (Feedback existing : feedbackList) {
            if (existing.getId() == feedback.getId()) {
                return ResponseEntity.status(409).build();
            }
        }

        feedbackList.add(feedback);
        return ResponseEntity.status(201).body(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable int id,
            @RequestBody Feedback updated) {

        if (!customerController.getCustomerById(updated.getCustomerId())
                .getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }

        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                feedback.setCustomerId(updated.getCustomerId());
                feedback.setMessage(updated.getMessage());
                feedback.setRating(updated.getRating());
                return ResponseEntity.ok(feedback);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable int id) {
        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                feedbackList.remove(feedback);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCustomer(
            @PathVariable int customerId) {

        if (!customerController.getCustomerById(customerId)
                .getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.notFound().build();
        }

        List<Feedback> result = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (feedback.getCustomerId() == customerId) {
                result.add(feedback);
            }
        }

        return ResponseEntity.ok(result);
    }
}
