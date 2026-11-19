package com.reddesk.desk_api.Controller;

import com.reddesk.desk_api.model.Customer;
import com.reddesk.desk_api.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path = "/feedback")
public class FeedbackController {

    public static ArrayList<Feedback> listOfFeedback = new ArrayList<>();

    @GetMapping
    public ArrayList<Feedback> getAllFeedback() {
        return listOfFeedback;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecificFeedback(@PathVariable String id) {

        Feedback foundFeedback = null;

        for (Feedback feedback : listOfFeedback) {
            if (feedback.id != null && feedback.id.equals(id)) {
                foundFeedback = feedback;
                break;
            }
        }

        if (foundFeedback == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Feedback not found"));
        }

        return ResponseEntity.ok(foundFeedback);
    }

    @PostMapping
    public ResponseEntity<?> registerFeedback(
            @RequestBody Feedback incomingFeedback) {

        Customer foundCustomer = null;

        for (Customer customer : CustomerController.listOfCustomers) {
            if (customer.id != null
                    && customer.id.equals(incomingFeedback.customerId)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Customer ID does not exist"));
        }

        listOfFeedback.add(incomingFeedback);

        return ResponseEntity.ok(incomingFeedback);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updatedFeedback) {

        Feedback foundFeedback = null;

        for (Feedback feedback : listOfFeedback) {
            if (feedback.id != null && feedback.id.equals(id)) {
                foundFeedback = feedback;
                break;
            }
        }

        if (foundFeedback == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Feedback not found"));
        }

        Customer foundCustomer = null;

        for (Customer customer : CustomerController.listOfCustomers) {
            if (customer.id != null
                    && customer.id.equals(updatedFeedback.customerId)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Customer ID does not exist"));
        }

        foundFeedback.id = id;
        foundFeedback.message = updatedFeedback.message;
        foundFeedback.customerId = updatedFeedback.customerId;

        return ResponseEntity.ok(foundFeedback);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {

        boolean removed = listOfFeedback.removeIf(
                feedback -> feedback.id != null && feedback.id.equals(id)
        );

        if (!removed) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Feedback not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Feedback deleted")
        );
    }
}