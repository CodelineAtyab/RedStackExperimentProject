package com.abdullah.employees.service;

import com.abdullah.employees.Customer;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {

    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomer(String id) {
        return customers.stream()
                .filter(customer -> id != null && id.equals(customer.id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Customer " + id + " not found"));
    }

    public boolean customerExists(String id) {
        return customers.stream()
                .anyMatch(customer -> id != null && id.equals(customer.id));
    }

    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Customer customer = getCustomer(id);
        customer.name = updatedCustomer.name;
        return customer;
    }

    public void removeCustomer(String id) {
        customers.remove(getCustomer(id));
    }
}