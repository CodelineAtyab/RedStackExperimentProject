package com.reddesk.desk_api.controller;

import com.reddesk.desk_api.dto.CustomerResponse;
import com.reddesk.desk_api.model.Customer;
import com.reddesk.desk_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CustomerResponse> getSpecificCustomer(@PathVariable String id) {
        Customer fetchedCustomer = customerService.getSpecificCustomer(id);
        if (fetchedCustomer.id == null && fetchedCustomer.name == null) {
            CustomerResponse response = new CustomerResponse("Customer not found", "INFO").setCustomerId("0", "Anonymous");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        CustomerResponse response = new CustomerResponse("Customer Exists!", "INFO").setCustomerId(fetchedCustomer.id, fetchedCustomer.name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer incomingCustomerObj) {
        Customer registeredCustomer = customerService.registerCustomer(incomingCustomerObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredCustomer);
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
