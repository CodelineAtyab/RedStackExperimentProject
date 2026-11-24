package com.Employees.EmpAPI.Controller;

import com.Employees.EmpAPI.Models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/feedback")
public class FeedbackController {
    public record Feedback(String id, String message, String customerId ){};
    public static List<Feedback> listOfFeedback = new ArrayList<>();

    @GetMapping
    public List<Feedback> getEmp(){
        return listOfFeedback;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                return ResponseEntity.ok(listOfFeedback.get(i));
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Feedback with ID " + id + " not found.");
    }

    @PostMapping
    public ResponseEntity<?> newFeedback(@RequestBody Feedback newFeed){
        if (newFeed.customerId() == null || newFeed.customerId().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("customerId is required.");
        }
        boolean customerExists = false;
        for (Customer customer : CustomerController.listOfCustomers) {
            if (customer.id().equals(newFeed.customerId())) {
                customerExists = true;
                break;
            }
        }
        if (!customerExists) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Customer with ID '" + newFeed.customerId() + "' does not exist.");
        }
        listOfFeedback.add(newFeed);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFeed);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Feedback newFeed){
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                Feedback xx = new Feedback(listOfFeedback.get(i).id(), newFeed.message , listOfFeedback.get(i).customerId);
                listOfFeedback.set(i,xx);
                return ResponseEntity.ok(xx);
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot update. Feedback with ID " + id + " not found.");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                listOfFeedback.remove(i);
                return ResponseEntity.ok(listOfFeedback);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot delete. Feedback with ID " + id + " not found.");
    }




}
