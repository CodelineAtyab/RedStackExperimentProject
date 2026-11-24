package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final List<Customer> customersList = new ArrayList<>();

    @GetMapping  // GET http://localhost:8080/customers
    public List<Customer> getAllCustomers() {
        return customersList;
    }

    @GetMapping("/{id}")  // GET http://localhost:8080/customers/2
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        for (Customer customer : customersList) {
            if (customer.getId() == id) {
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer) {
        for (Customer existing : customersList) {
            if (existing.getId() == newCustomer.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }


        customersList.add(newCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable int id,
            @RequestBody Customer updatedCustomer) {

        for (Customer customer : customersList) {
            if (customer.getId() == id) {
                customer.setName(updatedCustomer.getName());
                customer.setEmail(updatedCustomer.getEmail());
                return ResponseEntity.ok(customer);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        for (Customer customer : customersList) {
            if (customer.getId() == id) {
                customersList.remove(customer);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}