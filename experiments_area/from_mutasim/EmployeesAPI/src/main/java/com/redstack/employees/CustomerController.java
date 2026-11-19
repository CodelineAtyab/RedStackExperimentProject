package com.redstack.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// GET/POST structure adapted from trainer CustomerController at f3710cf.
// PUT, DELETE, linked feedback and error handling are new for issue #550.
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final InMemoryStore store;

    public CustomerController(InMemoryStore store) {
        this.store = store;
    }

    @GetMapping
    public List<Customer> getAll() {
        return store.customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return store.customers.stream().filter(c -> id.equals(c.id)).findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        store.customers.add(customer);
        return ResponseEntity.status(201).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Customer replacement) {
        for (int i = 0; i < store.customers.size(); i++) {
            if (id.equals(store.customers.get(i).id)) {
                replacement.id = id; // URL is authoritative even if body contains another ID.
                store.customers.set(i, replacement);
                return ResponseEntity.ok(replacement);
            }
        }
        return notFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean removed = store.customers.removeIf(c -> id.equals(c.id));
        if (!removed) return notFound(id);
        store.feedback.removeIf(f -> id.equals(f.customerId)); // Cascade delete.
        return ResponseEntity.ok(Map.of("message", "Customer " + id + " and their feedback removed"));
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getFeedbackForCustomer(@PathVariable String id) {
        boolean exists = store.customers.stream().anyMatch(c -> id.equals(c.id));
        if (!exists) return notFound(id);
        List<Feedback> result = new ArrayList<>();
        for (Feedback item : store.feedback) {
            if (id.equals(item.customerId)) result.add(item);
        }
        return ResponseEntity.ok(result);
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(404).body(Map.of("message", "Customer with id " + id + " not found"));
    }
}
