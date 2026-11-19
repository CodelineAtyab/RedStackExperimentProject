package com.example.employee_api.Controller;

import java.util.List;

import com.example.employee_api.CustomerService;
import com.example.employee_api.FeedbackService;
import com.example.employee_api.Model.Customer;
import com.example.employee_api.Model.Feedback;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final FeedbackService feedbackService;

    public CustomerController(CustomerService customerService, FeedbackService feedbackService) {
        this.customerService = customerService;
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getSpecificCustomer(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping("/{id}/feedback")
    public List<Feedback> getCustomerFeedback(@PathVariable String id) {
        customerService.findById(id);
        return feedbackService.findByCustomerId(id);
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer incomingCustomer) {
        return customerService.create(incomingCustomer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer incomingCustomer) {
        return customerService.update(id, incomingCustomer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        feedbackService.deleteByCustomerId(id);
        return "Customer with ID " + id + " has been deleted.";
    }
}
