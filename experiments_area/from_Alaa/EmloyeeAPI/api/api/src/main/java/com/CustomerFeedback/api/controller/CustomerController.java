package com.CustomerFeedback.api.controller;

//controller is the request handle

import com.CustomerFeedback.api.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //create object and the object is singleton
@RequestMapping(path = "/customers")
public class CustomerController {
    /* Objects we need to include
            * Customer
            * admin
            * employee
            * Feedback
                * Rating
                *
            * TrainingProject
        we think of them as resources
     */

    //beans are objects created by springboot

    ArrayList <Customer> AllCustomers= new ArrayList<>();


    @GetMapping
    public ArrayList <Customer> getCustomers(){ //the String should be a Customer
        return  AllCustomers ; //we return customers
    }

    //if we want to return a specific customer /customers/id
    @GetMapping(path = "/{id}")
    public Customer getspecific(@PathVariable String id){
        return null ;
    }

    @PostMapping // to submit data through json
    public Customer register (@RequestBody Customer incomingCust){// creat Customer object
        AllCustomers.add(incomingCust);
        return null;
    }//Spring is going deserialize the data


}
