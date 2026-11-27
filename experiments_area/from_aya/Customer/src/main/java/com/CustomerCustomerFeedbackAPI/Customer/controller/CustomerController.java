package com.CustomerCustomerFeedbackAPI.Customer.controller;

import com.CustomerCustomerFeedbackAPI.Customer.model.Customer;
import com.CustomerCustomerFeedbackAPI.Customer.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    static List<Customer> customers = new ArrayList<>();

    // POST
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // GET all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // GET customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updatedCustomer) {

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(updatedCustomer.getName());
                return new ResponseEntity<>(customer, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(id)) {

                customers.remove(i);

                // Delete feedback belonging to this customer
                for (int j = FeedbackController.feedbacks.size() - 1; j >= 0; j--) {
                    if (FeedbackController.feedbacks.get(j).getCustomerId().equals(id)) {
                        FeedbackController.feedbacks.remove(j);
                    }
                }

                return new ResponseEntity<>("Removed", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
    }

    // GET feedback of one customer
    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {

        boolean found = false;

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                found = true;
                break;
            }
        }

        if (!found) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }

        List<Feedback> customerFeedback = new ArrayList<>();

        for (Feedback feedback : FeedbackController.feedbacks) {
            if (feedback.getCustomerId().equals(id)) {
                customerFeedback.add(feedback);
            }
        }

        return new ResponseEntity<>(customerFeedback, HttpStatus.OK);
    }
}
