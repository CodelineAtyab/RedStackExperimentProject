package com.redstack.feedbackcrudcustomerlink.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.redstack.feedbackcrudcustomerlink.model.Customer;
import com.redstack.feedbackcrudcustomerlink.store.InMemoryDataStore;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final List<Customer> customers = InMemoryDataStore.customers;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping(path = "/{id}")
    public Customer getSpecificCustomer(@PathVariable String id) {
        for (Customer currCustomer : customers) {
            if (currCustomer.id.equals(id)) {
                return currCustomer;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: id=" + id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer request) {
        for (Customer currCustomer : customers) {
            if (currCustomer.id.equals(id)) {
                currCustomer.name = request.name;
                return currCustomer;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: id=" + id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable String id) {
        boolean hasFeedback = InMemoryDataStore.feedbackList.stream()
                .anyMatch(feedback -> id.equals(feedback.customerId));
        if (hasFeedback) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Customer has feedback and cannot be deleted: id=" + id);
        }
        boolean removed = customers.removeIf(currCustomer -> currCustomer.id.equals(id));
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: id=" + id);
        }
    }
}
