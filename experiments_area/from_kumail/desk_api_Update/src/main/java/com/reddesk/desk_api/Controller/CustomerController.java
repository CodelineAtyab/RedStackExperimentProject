package com.reddesk.desk_api.Controller;

import com.reddesk.desk_api.model.Customer;
import com.reddesk.desk_api.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    public static ArrayList<Customer> listOfCustomers = new ArrayList<>();

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecificCustomer(@PathVariable String id) {

        Customer foundCustomer = null;

        for (Customer customer : listOfCustomers) {
            if (customer.id != null && customer.id.equals(id)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Customer not found"));
        }

        return ResponseEntity.ok(foundCustomer);
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomerObj) {
        listOfCustomers.add(incomingCustomerObj);
        return incomingCustomerObj;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable String id,
            @RequestBody Customer updatedCustomer) {

        Customer foundCustomer = null;

        for (Customer customer : listOfCustomers) {
            if (customer.id != null && customer.id.equals(id)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Customer not found"));
        }

        foundCustomer.id = id;
        foundCustomer.name = updatedCustomer.name;

        return ResponseEntity.ok(foundCustomer);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {

        boolean removed = listOfCustomers.removeIf(
                customer -> customer.id != null && customer.id.equals(id)
        );

        if (!removed) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Customer not found"));
        }

        FeedbackController.listOfFeedback.removeIf(
                feedback -> feedback.customerId != null
                        && feedback.customerId.equals(id)
        );

        return ResponseEntity.ok(
                Map.of("message", "Customer and their feedback deleted")
        );
    }

    @GetMapping(path = "/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable String id) {

        Customer foundCustomer = null;

        for (Customer customer : listOfCustomers) {
            if (customer.id != null && customer.id.equals(id)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Customer not found"));
        }

        ArrayList<Feedback> customerFeedback = new ArrayList<>();

        for (Feedback feedback : FeedbackController.listOfFeedback) {
            if (feedback.customerId != null && feedback.customerId.equals(id)) {
                customerFeedback.add(feedback);
            }
        }

        return ResponseEntity.ok(customerFeedback);
    }
}