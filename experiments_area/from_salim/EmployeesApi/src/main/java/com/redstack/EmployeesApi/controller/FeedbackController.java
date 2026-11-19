package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.model.Customer;
import com.redstack.EmployeesApi.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.redstack.EmployeesApi.controller.CustomerController.customers;
import static com.redstack.EmployeesApi.controller.CustomerController.feedback;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedback;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable String id) {
        Optional<Feedback> found = findFeedback(id);

        if (found.isEmpty()) {
            return feedbackNotFound(id);
        }

        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<?> createFeedback(@RequestBody Feedback newFeedback) {
        if (findCustomer(newFeedback.customerId).isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Customer " + newFeedback.customerId + " does not exist"));
        }

        feedback.add(newFeedback);
        return ResponseEntity.ok(newFeedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback replacement) {

        Optional<Feedback> existing = findFeedback(id);

        if (existing.isEmpty()) {
            return feedbackNotFound(id);
        }

        if (findCustomer(replacement.customerId).isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Customer " + replacement.customerId + " does not exist"));
        }

        replacement.id = id;
        int index = feedback.indexOf(existing.get());
        feedback.set(index, replacement);

        return ResponseEntity.ok(replacement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {
        Optional<Feedback> found = findFeedback(id);

        if (found.isEmpty()) {
            return feedbackNotFound(id);
        }

        feedback.remove(found.get());

        return ResponseEntity.ok(Map.of("message", "Feedback " + id + " deleted"));
    }

    private Optional<Feedback> findFeedback(String id) {
        return feedback.stream().filter(item -> item.id.equals(id)).findFirst();
    }

    private Optional<Customer> findCustomer(String id) {
        return customers.stream().filter(customer -> customer.id.equals(id)).findFirst();
    }

    private ResponseEntity<Map<String, String>> feedbackNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Feedback " + id + " not found"));
    }
}
