package com.Linked.FeedbackLinked.service;

import com.Linked.FeedbackLinked.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public boolean customerExists(String customerId) {
        if (customerId == null) {
            return false;
        }
        Customer foundCustomer = customers.stream()
                .filter(currCustomer -> customerId.equals(currCustomer.getId()))
                .findFirst()
                .orElse(null);
        return foundCustomer != null;
    }

    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.status(200).body(customers);
    }

    public ResponseEntity<?> getCustomer(String id) {
        Customer foundCustomer = customers.stream()
                .filter(currCustomer -> currCustomer.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundCustomer != null) {
            return ResponseEntity.status(200).body(foundCustomer);
        }

        return ResponseEntity.status(404).body("Customer " + id + " not found");
    }

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(201).body(customer);
    }
}