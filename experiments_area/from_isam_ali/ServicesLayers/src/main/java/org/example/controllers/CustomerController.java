package org.example.controllers;

import java.util.List;
import java.util.Optional;

import org.example.Customer;
import org.example.Feedback;
import org.example.services.CustomerService;
import org.example.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Optional<Customer> found = customerService.getOne(id);
        if (found.isPresent()) {
            return ResponseEntity.ok(found.get());
        }
        return notFound(id);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer created = customerService.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getFeedbackOfCustomer(@PathVariable String id) {
        if (customerService.getOne(id).isEmpty()) {
            return notFound(id);
        }
        List<Feedback> result = feedbackService.getByCustomerId(id);
        return ResponseEntity.ok(result);
    }

    // TODO: PUT /customers/{id} and DELETE /customers/{id}
    // (write the logic in CustomerService, call it here in one line each)

    private ResponseEntity<String> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Customer " + id + " not found");
    }
}