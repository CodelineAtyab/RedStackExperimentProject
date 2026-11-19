package com.reddesk.desk_api.controller;

import com.reddesk.desk_api.model.Customer;
import com.reddesk.desk_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getSpecificCustomer(@PathVariable String id) {
        return customerService.getSpecificCustomer(id);
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomerObj) {
        return customerService.registerCustomer(incomingCustomerObj);
    }

    @PatchMapping(path = "/{id}")
    public Customer updateExistingCustomer(@PathVariable String id, @RequestBody Customer incomingCustomerObj) {
        return customerService.updateExistingCustomer(id, incomingCustomerObj);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteSpecific(@PathVariable String id) {
        return customerService.deleteSpecific(id);
    }

    @DeleteMapping
    public Boolean deleteAll() {
       return customerService.deleteAll();
    }
}
