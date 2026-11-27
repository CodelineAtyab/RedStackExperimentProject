package com.noor.employeesapi.service;

import com.noor.employeesapi.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customersList = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customersList;
    }


    public Customer getCustomerById(String id) {
        for (Customer customer : customersList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }


    public boolean addCustomer(Customer newCustomer) {
        for (Customer existing : customersList) {
            if (existing.getId().equals(newCustomer.getId())) {
                return false;
            }
        }

        customersList.add(newCustomer);
        return true;
    }



    public Customer updateCustomer(String id, Customer updatedCustomer) {
        for (Customer customer : customersList) {
            if (customer.getId().equals(id)) {
                customer.setName(updatedCustomer.getName());
                customer.setEmail(updatedCustomer.getEmail());
                return customer;
            }
        }

        return null;
    }


    public boolean deleteCustomer(String id) {
        Customer customer = getCustomerById(id);

        if (customer != null) {
            customersList.remove(customer);
            return true;
        }

        return false;
    }

}
