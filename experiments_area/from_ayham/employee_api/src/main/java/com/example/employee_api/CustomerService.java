package com.example.employee_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.employee_api.Exceptions.CustomerNotFoundException;
import com.example.employee_api.Model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAll() {
        return customers;
    }

    public Customer findById(String id) {
        return customers.stream()
                .filter(customer -> Objects.equals(customer.id, id))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer with ID " + id + " not found."));
    }

    public boolean exists(String id) {
        return customers.stream().anyMatch(customer -> Objects.equals(customer.id, id));
    }

    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer update(String id, Customer incomingCustomer) {
        Customer customer = findById(id);
        customer.name = incomingCustomer.name;
        return customer;
    }

    public void delete(String id) {
        customers.remove(findById(id));
    }
}
