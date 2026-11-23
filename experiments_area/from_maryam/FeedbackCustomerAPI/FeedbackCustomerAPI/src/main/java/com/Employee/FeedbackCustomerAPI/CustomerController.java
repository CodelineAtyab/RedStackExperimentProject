package com.Employee.FeedbackCustomerAPI;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static List<Customer> customers = new ArrayList<>();

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {

        customers.add(customer);
        return customer;
    }

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

            FeedbackController.feedbacks.removeIf((currFeedback) -> {
                return currFeedback.getCustomerId().equals(id);
            });

            customers.remove(foundCustomer);

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

        List<Feedback> customerFeedback = FeedbackController.feedbacks.stream().filter((currFeedback) -> {
            return currFeedback.getCustomerId().equals(id);
        }).toList();

        return ResponseEntity.ok(customerFeedback);
    }

}
