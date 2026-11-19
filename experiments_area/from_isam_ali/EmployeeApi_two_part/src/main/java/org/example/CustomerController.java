package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    public static final List<Customer> customers = new ArrayList<>();

    @GetMapping
    public List<Customer> getAll() {
        return customers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Customer customer = findCustomer(id);
        if (customer == null) {
            return notFound(id);
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }


    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getFeedbackOfCustomer(@PathVariable String id) {
        if (findCustomer(id) == null) {
            return notFound(id);
        }
        List<Feedback> result = FeedbackController.feedbackList.stream()
                .filter(f -> id.equals(f.getCustomerId()))
                .toList();
        return ResponseEntity.ok(result);
    }

    // TODO (you write these, copy the idea from your EmployeeController):
    // PUT    /customers/{id}
    // DELETE /customers/{id}   <- also decide what happens to that customer's feedback

    static Customer findCustomer(String id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private ResponseEntity<?> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "No customer with id " + id + " exists."));
    }
}