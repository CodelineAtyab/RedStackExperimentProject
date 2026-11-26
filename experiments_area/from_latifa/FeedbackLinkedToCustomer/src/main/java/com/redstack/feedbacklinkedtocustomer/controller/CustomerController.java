package com.redstack.feedbacklinkedtocustomer.controller;

import com.redstack.feedbacklinkedtocustomer.model.Customer;
import com.redstack.feedbacklinkedtocustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {

        Customer customer = customerService.getCustomerById(id);

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer " + id + " not found");
        }

        return ResponseEntity.ok(customer);
    }

    // Add customer
    @PostMapping
    public ResponseEntity<Customer> addCustomer(
            @RequestBody Customer customerToAdd) {

        Customer createdCustomer = customerService.addCustomer(customerToAdd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdCustomer);
    }
}
