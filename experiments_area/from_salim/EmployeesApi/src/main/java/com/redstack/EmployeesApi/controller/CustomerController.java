package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.service.CustomerService;
import com.redstack.EmployeesApi.model.Customer;
import com.redstack.EmployeesApi.service.FeedbackService;
import com.redstack.EmployeesApi.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isEmpty()) {
            return customerNotFound(id);
        }

        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer replacement) {

        Optional<Customer> updated =
                customerService.updateCustomer(id, replacement);

        if (updated.isEmpty()) {
            return customerNotFound(id);
        }

        return ResponseEntity.ok(updated.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        Optional<Customer> existing = customerService.getCustomerById(id);

        if (existing.isEmpty()) {
            return customerNotFound(id);
        }

        feedbackService.deleteFeedbackForCustomer(id);
        customerService.deleteCustomer(id);

        return ResponseEntity.ok(Map.of("message", "Customer " + id + " and their feedback deleted"));
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {
        if (customerService.getCustomerById(id).isEmpty()) {
            return customerNotFound(id);
        }

        return ResponseEntity.ok(feedbackService.getFeedbackForCustomer(id));
    }

    private ResponseEntity<Map<String, String>> customerNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Customer " + id + " not found"));
    }
}
