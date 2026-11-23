package com.teamred.employees;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    public List<Customer> getAll() {
        return DataStore.customers;
    }

    public Customer add(Customer customer) {
        DataStore.customers.add(customer);
        return customer;
    }

    // Used by FeedbackService to check that a customer exists
    public Optional<Customer> findById(String id) {
        return DataStore.customers.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst();
    }
}