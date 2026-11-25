package com.redstack.EmployeesApi.service;

import com.redstack.EmployeesApi.model.Customer;
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

    public Optional<Customer> getCustomerById(String id) {
        return customers.stream()
                .filter(customer -> customer.id.equals(id))
                .findFirst();
    }

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> updateCustomer(String id, Customer replacement) {
        Optional<Customer> existing = getCustomerById(id);

        if (existing.isEmpty()) {
            return Optional.empty();
        }

        replacement.id = id;
        int index = customers.indexOf(existing.get());
        customers.set(index, replacement);

        return Optional.of(replacement);
    }

    public Optional<Customer> deleteCustomer(String id) {
        Optional<Customer> existing = getCustomerById(id);
        existing.ifPresent(customers::remove);
        return existing;
    }

}
