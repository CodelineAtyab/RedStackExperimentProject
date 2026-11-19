package com.example.employees_api.Controllers;

import com.example.employees_api.Models.Customer;
import com.example.employees_api.Models.Feedback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>();
    private final FeedbackController feedbackController;

    public CustomerController(FeedbackController feedbackController) {
        this.feedbackController = feedbackController;
    }

    public boolean customerExists(String customerId) {
        if (customerId == null) {
            return false;
        }
        return customers.stream().anyMatch(c -> c.getId().equals(customerId));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable String id) {
        Optional<Customer> match = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (match.isPresent()) {
            return ResponseEntity.ok(match.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Customer with id '" + id + "' not found.");
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<Object> getFeedbackForCustomer(@PathVariable String id) {
        if (!customerExists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id '" + id + "' not found.");
        }
        List<Feedback> customerFeedback = feedbackController.getFeedbackByCustomerId(id);
        return ResponseEntity.ok(customerFeedback);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable String id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> match = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (match.isPresent()) {
            Customer existing = match.get();
            existing.setName(updatedCustomer.getName());
            return ResponseEntity.ok(existing);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Customer with id '" + id + "' not found for update.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        boolean removed = customers.removeIf(c -> c.getId().equals(id));

        if (!removed) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with id '" + id + "' not found for deletion.");
        }

        int removedFeedbackCount = feedbackController.deleteFeedbackByCustomerId(id);
        return ResponseEntity.ok(
                "Customer with id '" + id + "' removed along with " + removedFeedbackCount + " linked feedback item(s)."
        );
    }
}