package com.redstack.feedbackcrudcustomerlink.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.redstack.feedbackcrudcustomerlink.model.Customer;
import com.redstack.feedbackcrudcustomerlink.model.Feedback;
import com.redstack.feedbackcrudcustomerlink.store.InMemoryDataStore;

@RestController
public class FeedbackController {

    private final List<Feedback> feedbackList = InMemoryDataStore.feedbackList;

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    @GetMapping("/feedback/{id}")
    public Feedback getSpecificFeedback(@PathVariable String id) {
        for (Feedback currFeedback : feedbackList) {
            if (id.equals(currFeedback.id)) {
                return currFeedback;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found: id=" + id);
    }

    @PostMapping("/feedback")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        requireExistingCustomer(feedback.customerId);
        feedbackList.add(feedback);
        return feedback;
    }

    @PutMapping("/feedback/{id}")
    public Feedback updateFeedback(@PathVariable String id, @RequestBody Feedback request) {
        for (Feedback currFeedback : feedbackList) {
            if (id.equals(currFeedback.id)) {
                requireExistingCustomer(request.customerId);
                currFeedback.message = request.message;
                currFeedback.customerId = request.customerId;
                return currFeedback;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found: id=" + id);
    }

    @DeleteMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeedback(@PathVariable String id) {
        boolean removed = feedbackList.removeIf(currFeedback -> id.equals(currFeedback.id));
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found: id=" + id);
        }
    }

    @GetMapping("/customers/{id}/feedback")
    public List<Feedback> getFeedbackByCustomer(@PathVariable String id) {
        boolean customerExists = false;
        for (Customer currCustomer : InMemoryDataStore.customers) {
            if (id.equals(currCustomer.id)) {
                customerExists = true;
                break;
            }
        }
        if (!customerExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: id=" + id);
        }

        List<Feedback> customerFeedback = new ArrayList<>();
        for (Feedback currFeedback : feedbackList) {
            if (id.equals(currFeedback.customerId)) {
                customerFeedback.add(currFeedback);
            }
        }
        return customerFeedback;
    }

    private void requireExistingCustomer(String customerId) {
        for (Customer currCustomer : InMemoryDataStore.customers) {
            if (currCustomer.id != null && currCustomer.id.equals(customerId)) {
                return;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Customer does not exist: customerId=" + customerId);
    }

}
