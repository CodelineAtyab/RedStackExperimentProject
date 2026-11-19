package com.teamred.employees;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @GetMapping
    public List<Customer> getAllCustomers() {
        return DataStore.customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Optional<Customer> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        return ResponseEntity.ok(found.get());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        DataStore.customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody Customer updated) {
        Optional<Customer> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        int index = DataStore.customers.indexOf(found.get());
        updated.setId(id);
        DataStore.customers.set(index, updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        boolean removed = DataStore.customers.removeIf(c -> id.equals(c.getId()));
        if (!removed) {
            return notFound(id);
        }

        int removedFeedback = 0;
        int before = DataStore.feedbacks.size();
        DataStore.feedbacks.removeIf(f -> id.equals(f.getCustomerId()));
        removedFeedback = before - DataStore.feedbacks.size();
        return ResponseEntity.ok(Map.of("message",
                "Customer " + id + " deleted, together with " + removedFeedback + " feedback item(s)"));
    }



    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getFeedbackOfCustomer(@PathVariable String id) {
        if (findById(id).isEmpty()) {
            return notFound(id);
        }
        List<Feedback> result = DataStore.feedbacks.stream()
                .filter(f -> id.equals(f.getCustomerId()))
                .toList();
        return ResponseEntity.ok(result);
    }



    private Optional<Customer> findById(String id) {
        return DataStore.customers.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst();
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Customer with id " + id + " not found"));
    }
}
