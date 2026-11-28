
package com.redstack.employeeApi.services;

import com.redstack.employeeApi.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    // Get all customers
    public List<Customer> getCustomers() {
        return customers;
    }

    // Get customer by ID
    public Customer getCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    // Add customer
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    // Update customer
    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Customer customer = getCustomerById(id);

        if (customer == null) {
            return null;
        }

        customer.setName(updatedCustomer.getName());
        return customer;
    }

    // Delete customer
    public boolean deleteCustomer(String id) {
        Customer customer = getCustomerById(id);

        if (customer == null) {
            return false;
        }

        customers.remove(customer);
        return true;
    }

    // Check if customer exists
    public boolean customerExists(String id) {
        return getCustomerById(id) != null;
    }
}
