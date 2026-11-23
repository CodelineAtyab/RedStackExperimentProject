package com.redstack.LinkingFeedbackCustomer.controller;

import java.util.ArrayList;
import java.util.Map;

import com.redstack.LinkingFeedbackCustomer.model.Customer;
import com.redstack.LinkingFeedbackCustomer.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static ArrayList<Customer> customersList = new ArrayList<>();
    public static ArrayList<Feedback> feedbackList = new ArrayList<>();

    // Get all customers
    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return customersList;
    }

    // Get one customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {

        for (Customer currCustomer : customersList) {
            if (currCustomer.id.equals(id)) {
                return ResponseEntity.ok(currCustomer);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Customer not found!"));
    }

    // Add a new customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer newCustomer) {

        customersList.add(newCustomer);
        return newCustomer;
    }


    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updatedCustomer) {

        for (Customer currCustomer : customersList) {

            if (currCustomer.id.equals(id)) {
                currCustomer.name = updatedCustomer.name;
                return ResponseEntity.ok(currCustomer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Customer not found!"));
    }

    // Delete a specific customer
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        Customer foundCustomer = null;

        for (Customer currCustomer : customersList) {

            if (currCustomer.id.equals(id)) {
                foundCustomer = currCustomer;
                break;
            }
        }

        if (foundCustomer != null) {

            // Delete the feedback belonging to this customer
            feedbackList.removeIf(item -> item.customerId.equals(id));
            customersList.remove(foundCustomer);

            return ResponseEntity.ok(
                    Map.of("message", "Customer deleted successfully!")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Customer not found!"));
    }

    // Get all feedback for one customer
    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getFeedbackByCustomer(@PathVariable String id) {

        boolean customerExists = false;

        for (Customer currCustomer : customersList) {

            if (currCustomer.id.equals(id)) {
                customerExists = true;
                break;
            }
        }

        if (!customerExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Customer not found!"));
        }

        ArrayList<Feedback> customerFeedback = new ArrayList<>();

        for (Feedback currFeedback : feedbackList) {

            if (currFeedback.customerId.equals(id)) {
                customerFeedback.add(currFeedback);
            }
        }

        return ResponseEntity.ok(customerFeedback);
    }
}