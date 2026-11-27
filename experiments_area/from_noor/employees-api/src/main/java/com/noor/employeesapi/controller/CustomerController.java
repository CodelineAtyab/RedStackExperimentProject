package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Customer;
import com.noor.employeesapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping  // GET http://localhost:8080/customers
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")  // GET http://localhost:8080/customers/2
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public  ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer) {

        if (customerService.addCustomer(newCustomer)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updatedCustomer) {

        Customer customer = customerService.updateCustomer(id, updatedCustomer);

        if (customer != null) {
            return ResponseEntity.ok(customer);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}