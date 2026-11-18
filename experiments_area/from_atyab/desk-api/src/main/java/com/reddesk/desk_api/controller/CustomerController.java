package com.reddesk.desk_api.controller;

import com.reddesk.desk_api.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    ArrayList<Customer> listOfCustomers = new ArrayList<>();
    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    @GetMapping(path = "/{id}")
    public Customer getSpecificCustomer(@PathVariable String id) {
        Customer foundCustomer = listOfCustomers.stream().filter((currCustomer) -> {
            return currCustomer.id.equals(id);
        }).findFirst().get();

        return foundCustomer;
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomerObj) {
        listOfCustomers.add(incomingCustomerObj);
        return incomingCustomerObj;
    }
}
