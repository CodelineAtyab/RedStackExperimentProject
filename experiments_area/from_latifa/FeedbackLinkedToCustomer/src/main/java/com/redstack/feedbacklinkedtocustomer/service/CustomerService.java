package com.redstack.feedbacklinkedtocustomer.service;

import com.redstack.feedbacklinkedtocustomer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {
    private ArrayList<Customer> customersList = new ArrayList<>();

    // Get all customers
    public ArrayList<Customer> getAllCustomers() {
        return customersList;
    }

    // Get customer by ID
    public Customer getCustomerById(String id) {

        return customersList.stream()
                .filter(currCustomer -> currCustomer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add customer
    public Customer addCustomer(Customer customerToAdd) {

        customersList.add(customerToAdd);
        return customerToAdd;
    }
}
