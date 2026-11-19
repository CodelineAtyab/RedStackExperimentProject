
package com.example.RestControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/feedback")
public class FeedbackController {

    public static ArrayList<Feedback> listOfFeedback = new ArrayList<>();

    // GET all feedback
    @GetMapping
    public ArrayList<Feedback> getAllFeedback() {
        return listOfFeedback;
    }

    // GET one feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecificFeedback(@PathVariable String id) {

        Feedback foundFeedback = listOfFeedback.stream()
                .filter(feedback -> feedback.id.equals(id))
                .findFirst()
                .orElse(null);

        if (foundFeedback == null) {
            return ResponseEntity.status(404).body("Feedback not found");
        }

        return ResponseEntity.ok(foundFeedback);
    }

    // POST new feedback
    @PostMapping
    public ResponseEntity<?> addNewFeedback(@RequestBody Feedback incomingFeedback) {

        boolean customerExists = CustomerController.listOfCustomers.stream()
                .anyMatch(customer -> customer.id.equals(incomingFeedback.customerId));

        if (!customerExists) {
            return ResponseEntity.badRequest().body("Customer does not exist");
        }

        listOfFeedback.add(incomingFeedback);

        return ResponseEntity.ok(incomingFeedback);
    }

    // PUT update feedback
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable String id,
            @RequestBody Feedback updatedFeedback) {

        for (Feedback feedback : listOfFeedback) {

            if (feedback.id.equals(id)) {

                feedback.message = updatedFeedback.message;
                feedback.customerId = updatedFeedback.customerId;

                return ResponseEntity.ok(feedback);
            }
        }

        return ResponseEntity.status(404).body("Feedback not found");
    }

    // DELETE feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {

        Feedback feedbackToDelete = listOfFeedback.stream()
                .filter(feedback -> feedback.id.equals(id))
                .findFirst()
                .orElse(null);

        if (feedbackToDelete == null) {
            return ResponseEntity.status(404).body("Feedback not found");
        }

        listOfFeedback.remove(feedbackToDelete);

        return ResponseEntity.ok("Feedback deleted successfully");
    }
}
