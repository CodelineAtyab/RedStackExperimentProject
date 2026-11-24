package com.example.EmployeeApi.service;

import com.example.EmployeeApi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public ResponseEntity<?> getCustomerById(String id) {
        Optional<Customer> found = customers.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst();

        return found.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Customer not found: " + id));
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}