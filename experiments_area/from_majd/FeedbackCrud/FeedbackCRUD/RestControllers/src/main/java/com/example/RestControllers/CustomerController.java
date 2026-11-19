package com.example.RestControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    public static ArrayList<Customer> listOfCustomers = new ArrayList<>();

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecificCustomer(@PathVariable String id) {

        Customer foundCustomer = listOfCustomers.stream()
                .filter(customer -> customer.id.equals(id))
                .findFirst()
                .orElse(null);

        if (foundCustomer == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        return ResponseEntity.ok(foundCustomer);
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomerObj) {
        listOfCustomers.add(incomingCustomerObj);
        return incomingCustomerObj;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updatedCustomer) {

        for (Customer customer : listOfCustomers) {

            if (customer.id.equals(id)) {

                customer.name = updatedCustomer.name;

                return ResponseEntity.ok(customer);
            }
        }

        return ResponseEntity.status(404).body("Customer not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        Customer customerToDelete = listOfCustomers.stream()
                .filter(customer -> customer.id.equals(id))
                .findFirst()
                .orElse(null);

        if (customerToDelete == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        FeedbackController.listOfFeedback.removeIf(
                feedback -> feedback.customerId.equals(id)
        );
        listOfCustomers.remove(customerToDelete);

        return ResponseEntity.ok("Customer deleted successfully");
    }


    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {

        boolean customerExists = listOfCustomers.stream()
                .anyMatch(customer -> customer.id.equals(id));

        if (!customerExists) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        ArrayList<Feedback> customerFeedback = FeedbackController.listOfFeedback.stream()
                .filter(feedback -> feedback.customerId.equals(id))
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));

        return ResponseEntity.ok(customerFeedback);
    }


}
