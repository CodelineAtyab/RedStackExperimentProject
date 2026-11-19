package com.redstack.feedbackcrudcustomerlink.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redstack.feedbackcrudcustomerlink.model.Customer;
import com.redstack.feedbackcrudcustomerlink.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecificCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return customerNotFound(id);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody Customer request) {
        Optional<Customer> updated = customerService.updateCustomer(id, request);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        }
        return customerNotFound(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        if (customerService.customerHasFeedback(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Customer has feedback and cannot be deleted: id=" + id);
        }
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.ok("Customer deleted: id=" + id);
        }
        return customerNotFound(id);
    }

    private ResponseEntity<String> customerNotFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found: id=" + id);
    }
}
