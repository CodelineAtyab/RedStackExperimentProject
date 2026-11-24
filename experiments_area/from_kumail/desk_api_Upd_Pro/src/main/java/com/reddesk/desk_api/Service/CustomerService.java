package com.reddesk.desk_api.Service;

import com.reddesk.desk_api.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<Customer> getCustomerById(String id) {
        return customers.stream()
                .filter(customer -> customer.id.equals(id))
                .findFirst();
    }
}
