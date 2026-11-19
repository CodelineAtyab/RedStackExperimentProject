package com.abdullah.employees;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Feedback> feedbackList = new ArrayList<>();

    // Customer endpoints

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @GetMapping("/customers")
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") String id) {
        return findCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(
            @PathVariable("id") String id,
            @RequestBody Customer updatedCustomer) {

        Customer customer = findCustomer(id);
        customer.name = updatedCustomer.name;

        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public Map<String, String> deleteCustomer(
            @PathVariable("id") String id) {

        Customer customer = findCustomer(id);

        for (Feedback feedback : feedbackList) {
            if (id.equals(feedback.customerId)) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Delete this customer's feedback first."
                );
            }
        }

        customers.remove(customer);

        return Map.of("message", "Customer " + id + " removed");
    }

    // Feedback endpoints

    @PostMapping("/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        checkCustomerExists(feedback.customerId);
        feedbackList.add(feedback);

        return feedback;
    }

    @GetMapping("/feedback")
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

    @GetMapping("/feedback/{id}")
    public Feedback getFeedback(@PathVariable("id") String id) {
        return findFeedback(id);
    }

    @PutMapping("/feedback/{id}")
    public Feedback updateFeedback(
            @PathVariable("id") String id,
            @RequestBody Feedback updatedFeedback) {

        Feedback feedback = findFeedback(id);

        // Check before changing anything in the stored feedback.
        checkCustomerExists(updatedFeedback.customerId);

        feedback.message = updatedFeedback.message;
        feedback.customerId = updatedFeedback.customerId;

        return feedback;
    }

    @DeleteMapping("/feedback/{id}")
    public Map<String, String> deleteFeedback(
            @PathVariable("id") String id) {

        Feedback feedback = findFeedback(id);
        feedbackList.remove(feedback);

        return Map.of("message", "Feedback " + id + " removed");
    }

    @GetMapping("/customers/{id}/feedback")
    public ArrayList<Feedback> getCustomerFeedback(
            @PathVariable("id") String id) {

        findCustomer(id);

        ArrayList<Feedback> customerFeedback = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (id.equals(feedback.customerId)) {
                customerFeedback.add(feedback);
            }
        }

        return customerFeedback;
    }

    // Search helpers

    private Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (id.equals(customer.id)) {
                return customer;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Customer " + id + " not found"
        );
    }

    private Feedback findFeedback(String id) {
        for (Feedback feedback : feedbackList) {
            if (id.equals(feedback.id)) {
                return feedback;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Feedback " + id + " not found"
        );
    }

    private void checkCustomerExists(String customerId) {
        for (Customer customer : customers) {
            if (customer.id != null
                    && customer.id.equals(customerId)) {
                return;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Cannot save feedback: customer does not exist."
        );
    }
}