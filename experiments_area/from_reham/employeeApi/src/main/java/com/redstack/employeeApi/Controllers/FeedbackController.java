package com.redstack.employeeApi.Controllers;

import com.redstack.employeeApi.Customer;
import com.redstack.employeeApi.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    //to store the feedback in memory
    public static List<Feedback> feedbacks = new ArrayList<>();

    //GET ALL FEDDBACK
    @GetMapping
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    //GET ONE FEEDBACK
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int id) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getId()==id) {
                return ResponseEntity.ok(feedback);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message","Feedback not found"));
    }

    //Post - Add feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
        boolean customerExists = false;
        //check if cust exists
        for(Customer customer: CustomerController.customers){
            if (customer.getId() == Integer.parseInt(feedback.getCustomerId())){
                customerExists = true;
                break;
            }
        }
        if(!customerExists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message","Customer not found"));
        }
        feedbacks.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    // PUT - Update feedback
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeedback(
            @PathVariable int id,
            @RequestBody Feedback feedback) {

        Feedback foundFeedback = null;

        // Find the existing feedback
        for (Feedback feedback1 : feedbacks) {
            if (feedback1.getId() == id) {
                foundFeedback = feedback1;
                break;
            }
        }

        // Check if feedback exists
        if (foundFeedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Feedback not found"));
        }

        // Check if the customer exists
        boolean customerExists = false;

        for (Customer customer : CustomerController.customers) {
            if (customer.getId()==Integer.parseInt(feedback.getCustomerId())) {
                customerExists = true;
                break;
            }
        }

        if (!customerExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Customer not found"));
        }

        // Update the existing feedback
        foundFeedback.setMessage(feedback.getMessage());
        foundFeedback.setCustomerId(feedback.getCustomerId());

        return ResponseEntity.ok(foundFeedback);
    }

    //DELETEING A FEEDBACK
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int id) {
        Feedback foundFeedback = null;
        for (Feedback feedback : feedbacks) {
            if(feedback.getId()==id){
                foundFeedback=feedback;
                break;
            }
        }
        if(foundFeedback==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message","Feedback not found"));
        }
        feedbacks.remove(foundFeedback);
        return ResponseEntity.ok(Map.of("message","Feedback deleted"));
    }

}
