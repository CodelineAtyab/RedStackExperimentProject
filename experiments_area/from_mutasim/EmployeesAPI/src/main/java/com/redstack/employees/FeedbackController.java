package com.redstack.employees;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final InMemoryStore store;

    public FeedbackController(InMemoryStore store) {
        this.store = store;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Feedback item) {
        if (!customerExists(item.customerId)) return unknownCustomer(item.customerId);
        store.feedback.add(item);
        return ResponseEntity.status(201).body(item);
    }

    @GetMapping
    public List<Feedback> getAll() {
        return store.feedback;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return store.feedback.stream().filter(f -> id.equals(f.id)).findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Feedback replacement) {
        for (int i = 0; i < store.feedback.size(); i++) {
            if (id.equals(store.feedback.get(i).id)) {
                if (!customerExists(replacement.customerId)) return unknownCustomer(replacement.customerId);
                replacement.id = id;
                store.feedback.set(i, replacement);
                return ResponseEntity.ok(replacement);
            }
        }
        return notFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean removed = store.feedback.removeIf(f -> id.equals(f.id));
        if (!removed) return notFound(id);
        return ResponseEntity.ok(Map.of("message", "Feedback " + id + " removed"));
    }

    private boolean customerExists(String id) {
        return store.customers.stream().anyMatch(c -> id != null && id.equals(c.id));
    }

    private ResponseEntity<Map<String, String>> unknownCustomer(String id) {
        return ResponseEntity.badRequest().body(Map.of("message", "Customer with id " + String.valueOf(id) + " does not exist"));
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(404).body(Map.of("message", "Feedback with id " + id + " not found"));
    }
}
