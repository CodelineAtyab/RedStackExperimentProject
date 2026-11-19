package com.reddesk.desk_api.service;

import com.reddesk.desk_api.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {
    private ArrayList<Customer> listOfCustomers = new ArrayList<>();

    public ArrayList<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    public Customer getSpecificCustomer(String id) {
        Optional<Customer> firstCustomerResource = listOfCustomers.stream().filter((currCustomer) -> {
            return currCustomer.id.equals(id);
        }).findFirst();

        return firstCustomerResource.orElse(new Customer());
    }

    public Customer registerCustomer(Customer incomingCustomerObj) {
        listOfCustomers.add(incomingCustomerObj);
        return incomingCustomerObj;
    }

    public Customer updateExistingCustomer(String id, Customer incomingCustomerObj) {
        Customer existingCustomer = null;
        Optional<Customer> firstCustomerResource = listOfCustomers.stream().filter((currCustomer) -> {
            return currCustomer.id.equals(id);
        }).findFirst();

        if (firstCustomerResource.isPresent()) {
            existingCustomer = firstCustomerResource.get();
            existingCustomer.name = incomingCustomerObj.name;
        }

        return existingCustomer;
    }

    public Boolean deleteSpecific(String id) {
        Optional<Customer> firstCustomerResource = listOfCustomers.stream().filter((currCustomer) -> {
            return currCustomer.id.equals(id);
        }).findFirst();

        listOfCustomers.remove(firstCustomerResource.get());
        return true;
    }

    public Boolean deleteAll() {
        listOfCustomers = new ArrayList<>();
        return true;
    }
}
