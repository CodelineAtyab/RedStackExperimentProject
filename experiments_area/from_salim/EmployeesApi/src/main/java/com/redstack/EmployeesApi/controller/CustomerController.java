package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.model.Customer;
import com.redstack.EmployeesApi.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public static final List<Customer> customers = new ArrayList<>();
    public static final List<Feedback> feedback = new ArrayList<>();

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Optional<Customer> customer = findCustomer(id);

        if (customer.isEmpty()) {
            return customerNotFound(id);
        }

        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer replacement) {

        Optional<Customer> existing = findCustomer(id);

        if (existing.isEmpty()) {
            return customerNotFound(id);
        }

        replacement.id = id;
        int index = customers.indexOf(existing.get());
        customers.set(index, replacement);

        return ResponseEntity.ok(replacement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customer = findCustomer(id);

        if (customer.isEmpty()) {
            return customerNotFound(id);
        }

        // Chosen behavior: deleting a customer deletes their feedback too.
        feedback.removeIf(item -> item.customerId.equals(id));
        customers.remove(customer.get());

        return ResponseEntity.ok(
                Map.of("message", "Customer " + id + " and their feedback deleted"));
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {
        if (findCustomer(id).isEmpty()) {
            return customerNotFound(id);
        }

        List<Feedback> customerFeedback = feedback.stream()
                .filter(item -> item.customerId.equals(id))
                .toList();

        return ResponseEntity.ok(customerFeedback);
    }

    private Optional<Customer> findCustomer(String id) {
        return customers.stream()
                .filter(customer -> customer.id.equals(id))
                .findFirst();
    }

    private ResponseEntity<Map<String, String>> customerNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Customer " + id + " not found"));
    }

}
