package com.redstack.employeeApi.Controllers;

import com.redstack.employeeApi.Customer;
import com.redstack.employeeApi.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static List<Customer> customers = new ArrayList<>();

    //Get customer
    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        if (customers.isEmpty()) {
            return ResponseEntity.ok("No customers found");
        }
        return ResponseEntity.ok(customers);
    }


    //Get one customer
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        if (customers.isEmpty()) {
            return ResponseEntity.ok("No customers found");
        }
        for(Customer customer : customers){
            if(customer.getId() == id){
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");   }


    //add customer
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok("Customer created");
    }

    //Update Customer
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        if(customers.isEmpty()){
            return ResponseEntity.ok("No customers found");
        }
        for (Customer c : customers) {
            if(c.getId() == customer.getId()){
                c.setName(customer.getName());
                return ResponseEntity.ok("Customer updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not founf");
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
         Customer foundCustomer = null ;
         for (Customer customer : customers) {
             if (customer.getId() == id){
                 foundCustomer = customer;
                 break;
             }
         }
         if (foundCustomer == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
         }
         FeedbackController.feedbacks.removeIf(feedback -> feedback.getCustomerId().equals(id));
         customers.remove(foundCustomer);
         return ResponseEntity.ok("Customer deleted");
    }

    //Get All feedbacks belongs to one specific customer
    @GetMapping("/{id}/feedback")
    public ResponseEntity<?> getCustomerFeedback(@PathVariable int id) {
        boolean customerFound = false;
        for (Feedback feedback : FeedbackController.feedbacks) {
            if (feedback.getId() == id) {
                customerFound = true;
                break;
            }
        }
        if (!customerFound) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id " + id + " not found");
        }
        List<Feedback> customerFeedbacks = FeedbackController.feedbacks
                .stream() //Allowes us to process and filtter elemets from the collection
                .filter(feedback -> feedback.getCustomerId().equals(id))
                .toList();//converts the filterd stream back to a list
        return ResponseEntity.ok(customerFeedbacks);
    }




}
