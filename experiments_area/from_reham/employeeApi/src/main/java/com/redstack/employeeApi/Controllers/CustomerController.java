package com.redstack.employeeApi.Controllers;

import com.redstack.employeeApi.Customer;
import com.redstack.employeeApi.Feedback;
import com.redstack.employeeApi.services.FeedbackService;
import com.redstack.employeeApi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FeedbackService feedbackService;

    //Get all customers
    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getCustomers();

        if (customers.isEmpty()) {
            return ResponseEntity.ok("No customers found");
        }

        return ResponseEntity.ok(customers);
    }

    //Get one customer
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id " + id + " not found");
        }

        return ResponseEntity.ok(customer);
    }

    //Add customer
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Customer created");
    }

    //Update customer (uses the id from the URL)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer customer) {

        Customer updatedCustomer = customerService.updateCustomer(id, customer);

        if (updatedCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id " + id + " not found");
        }

        return ResponseEntity.ok("Customer updated");
    }

    //Delete customer and all of their feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        if (!customerService.customerExists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id " + id + " not found");
        }
        feedbackService.deleteFeedbackByCustomerId(id);

        customerService.deleteCustomer(id);

        return ResponseEntity.ok("Customer deleted");
    }


    //Get all feedback that belongs to one specific customer
    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {

        if (!customerService.customerExists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id " + id + " not found");
        }
        List<Feedback> customerFeedbacks = feedbackService.getFeedbackByCustomerId(id);
        return ResponseEntity.ok(customerFeedbacks);
    }
}