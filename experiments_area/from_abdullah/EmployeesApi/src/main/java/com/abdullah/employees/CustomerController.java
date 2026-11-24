package com.abdullah.employees;

import com.abdullah.employees.service.CustomerService;
import com.abdullah.employees.service.FeedbackService;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(
            @RequestBody Customer customer) {

        return ResponseEntity.status(201)
                .body(customerService.addCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(
            @PathVariable("id") String id) {

        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable("id") String id,
            @RequestBody Customer customer) {

        return ResponseEntity.ok(
                customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCustomer(
            @PathVariable("id") String id) {

        return ResponseEntity.ok(feedbackService.deleteCustomer(id));
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<ArrayList<Feedback>> getCustomerFeedback(
            @PathVariable("id") String id) {

        return ResponseEntity.ok(
                feedbackService.getCustomerFeedback(id));
    }
}