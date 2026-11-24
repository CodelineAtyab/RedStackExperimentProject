package com.CRUD.EmployeesCRUD.controller;

import com.CRUD.EmployeesCRUD.model.Customer;
import com.CRUD.EmployeesCRUD.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static List<Customer> customers = new ArrayList<>();

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Customer foundCustomer = customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundCustomer != null) {
            return ResponseEntity.ok(foundCustomer);
        }

        return ResponseEntity.status(404).body("Customer not found");
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updateCustomer) {

        Customer foundCustomer = customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundCustomer != null) {
            foundCustomer.setName(updateCustomer.getName());
            return ResponseEntity.ok(foundCustomer);
        }

        return ResponseEntity.status(404).body("Customer not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        Customer foundCustomer = customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundCustomer != null) {
            customers.remove(foundCustomer);
            FeedbackController.feedbackList.removeIf(fb -> id.equals(fb.getCustomerId()));
            return ResponseEntity.ok("Customer deleted");
        }

        return ResponseEntity.status(404).body("Customer not found");
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {
        Customer foundCustomer = customers.stream().filter((currCustomer) -> {
            return currCustomer.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundCustomer == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        List<Feedback> customerFeedback = FeedbackController.feedbackList.stream()
                .filter(fb -> id.equals(fb.getCustomerId()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(customerFeedback);
    }
}