package com.redstack.employeeApi.Controllers;

import com.redstack.employeeApi.Customer;
import com.redstack.employeeApi.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static List<Customer> customers = new ArrayList<>();

    //Get all customers
    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        if (customers.isEmpty()) {
            return ResponseEntity.ok("No customers found");
        }
        return ResponseEntity.ok(customers);
    }

    //Get one customer
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
    }

    //Add customer
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok("Customer created");
    }

    //Update customer (uses the id from the URL)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                c.setName(customer.getName());
                return ResponseEntity.ok("Customer updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
    }

    //Delete customer and all of their feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                foundCustomer = customer;
                break;
            }
        }
        if (foundCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
        }
        // customerId is a String, so compare it with the id as text
        FeedbackController.feedbacks.removeIf(feedback -> String.valueOf(id).equals(feedback.getCustomerId()));
        customers.remove(foundCustomer);
        return ResponseEntity.ok("Customer deleted");
    }

    //Get all feedback that belongs to one specific customer
    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable int id) {
        // check that the customer exists in the customers list
        boolean customerFound = false;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customerFound = true;
                break;
            }
        }
        if (!customerFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
        }
        List<Feedback> customerFeedbacks = FeedbackController.feedbacks
                .stream() //allows us to process and filter elements from the collection
                .filter(feedback -> String.valueOf(id).equals(feedback.getCustomerId()))
                .toList(); //converts the filtered stream back to a list
        return ResponseEntity.ok(customerFeedbacks);
    }
}