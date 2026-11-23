package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    // The customer list now lives here (it was a static list in CustomerController)
    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAll() {
        return customers;
    }

    public Optional<Customer> getOne(String id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    // TODO: move YOUR update(...) and deleteOne(...) from CustomerController into this class,
    // the same way as in EmployeeService.
}