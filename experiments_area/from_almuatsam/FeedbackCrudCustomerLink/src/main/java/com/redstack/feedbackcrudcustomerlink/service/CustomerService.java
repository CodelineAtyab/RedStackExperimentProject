package com.redstack.feedbackcrudcustomerlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.redstack.feedbackcrudcustomerlink.model.Customer;
import com.redstack.feedbackcrudcustomerlink.store.InMemoryDataStore;

@Service
public class CustomerService {

    private final List<Customer> customers = InMemoryDataStore.customers;

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Optional<Customer> getCustomerById(String id) {
        return customers.stream()
                .filter(currCustomer -> id.equals(currCustomer.id))
                .findFirst();
    }

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> updateCustomer(String id, Customer request) {
        Optional<Customer> existing = getCustomerById(id);
        existing.ifPresent(currCustomer -> currCustomer.name = request.name);
        return existing;
    }

    public boolean deleteCustomer(String id) {
        return customers.removeIf(currCustomer -> id.equals(currCustomer.id));
    }

    public boolean customerHasFeedback(String id) {
        return InMemoryDataStore.feedbackList.stream()
                .anyMatch(feedback -> id.equals(feedback.customerId));
    }
}
