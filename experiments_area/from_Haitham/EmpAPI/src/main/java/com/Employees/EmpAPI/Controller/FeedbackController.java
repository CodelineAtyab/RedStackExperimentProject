package com.Employees.EmpAPI.Controller;

import com.Employees.EmpAPI.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/feedback")
public class FeedbackController {
    public record Feedback(String id, String message, String customerId ){};
    public static List<Feedback> listOfFeedback = FeedbackService.listOfFeedback;
    @Autowired
    FeedbackService feedbackService;


    @GetMapping
    public ResponseEntity<?> getFeedback(){
        List<Feedback> feed = feedbackService.getAllFeedback();
        return ResponseEntity.ok(feed);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){
        Feedback feed = feedbackService.getSpecificId(id);
        if(feed != null){
            return ResponseEntity.ok(feed);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Feedback with ID " + id + " not found.");
        }
    }


    @PostMapping
    public ResponseEntity<?> newFeedback(@RequestBody Feedback newFeed){
        if (newFeed.customerId() == null || newFeed.customerId().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("customerId is required.");
        }
        Feedback saved = feedbackService.newFeedbackk(newFeed);
        if(saved != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Customer with ID '" + newFeed.customerId() + "' does not exist.");
        }
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Feedback newFeed){
        Feedback updated = feedbackService.updatee(id, newFeed);
        if(updated != null) {
            return ResponseEntity.ok(updated);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Cannot update. Feedback with ID " + id + " not found.");
        }
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         boolean check = feedbackService.deletee(id);
         if(check){
            return ResponseEntity.ok("Feedback " + id + " deleted.");

         }else {
             return ResponseEntity
                     .status(HttpStatus.NOT_FOUND) // 404 Not Found
                     .body("Cannot delete. Feedback with ID " + id + " not found.");
         }
    }



    @DeleteMapping
    public ResponseEntity<?> deleteAll (@RequestParam(required = false) Boolean confirm){
        boolean check = feedbackService.deleteAlll(confirm);
        if(!check){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                    .body("Confirmation required. Add ?confirm=true to delete all feedback.");
        }else {
            return ResponseEntity.ok("All feedback deleted.");
        }

    }
}
