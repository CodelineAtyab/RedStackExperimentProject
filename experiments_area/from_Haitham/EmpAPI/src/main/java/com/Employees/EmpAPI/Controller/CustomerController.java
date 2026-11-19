package com.Employees.EmpAPI.Controller;


import com.Employees.EmpAPI.Models.Customer;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if(listOfCustomers.get(i).id().equals(id)){
                return ResponseEntity.ok(listOfCustomers.get(i));
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Customer with ID " + id + " not found.");
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomerObj) {
        listOfCustomers.add(incomingCustomerObj);
        return incomingCustomerObj;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Customer incomingCustomerObj){
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if(listOfCustomers.get(i).id().equals(id)){
                Customer xx = new Customer((String) listOfCustomers.get(i).id(), incomingCustomerObj.name);
                listOfCustomers.set(i,xx);
                return ResponseEntity.ok(xx);
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot update. Customer with ID " + id + " not found.");
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if(listOfCustomers.get(i).id().equals(id)){
                for (int j = FeedbackController.listOfFeedback.size()-1; j >= 0; j--) {
                    if(FeedbackController.listOfFeedback.get(j).customerId().equals(id)){
                    FeedbackController.listOfFeedback.remove(j);
                    }

                }
                listOfCustomers.remove(i);
                return ResponseEntity.ok(listOfCustomers);
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot delete. Customer with ID " + id + " not found.");
    }

    @GetMapping(path = "/{id}/feedback")
    public ResponseEntity<?> getallfeedback(@PathVariable String id) {
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if (listOfCustomers.get(i).id().equals(id)) {
                ArrayList<FeedbackController.Feedback> customerFeedback = new ArrayList<>();
                for (FeedbackController.Feedback xx : FeedbackController.listOfFeedback) {
                    if (xx.customerId().equals(id)) {
                        customerFeedback.add(xx);
                    }
                }
                return ResponseEntity.ok(customerFeedback);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Customer with ID " + id + " not found.");
    }

}