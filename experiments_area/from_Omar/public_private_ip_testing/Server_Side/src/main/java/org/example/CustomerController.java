package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final Datastore store;

    public CustomerController(Datastore store) {
        this.store = store;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return store.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = store.getCustomers().stream()
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElse(null);

        if (customer == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        store.getCustomers().add(customer);
        return customer;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer incoming) {
        List<Customer> list = store.getCustomers();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id().equals(id)) {
                Customer updated = new Customer(id, incoming.name());
                list.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        boolean removed = store.getCustomers().removeIf(c -> c.id().equals(id));
        if (!removed) {
            return ResponseEntity.status(404).body("Customer with ID " + id + " not found.");
        }
        store.getFeedbackList().removeIf(f -> f.customerId().equals(id));
        return ResponseEntity.ok("Successfully deleted customer and their associated feedback.");
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<List<Feedback>> getFeedbackByCustomer(@PathVariable String id) {
        boolean customerExists = store.getCustomers().stream().anyMatch(c -> c.id().equals(id));
        if (!customerExists) {
            return ResponseEntity.status(404).build();
        }

        List<Feedback> customerFeedback = store.getFeedbackList().stream()
                .filter(f -> f.customerId().equals(id))
                .toList();

        return ResponseEntity.ok(customerFeedback);
    }
}