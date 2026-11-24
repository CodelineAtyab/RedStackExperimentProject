package com.abdullah.employees.service;

import com.abdullah.employees.Feedback;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FeedbackService {

    private ArrayList<Feedback> feedbackList = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public Feedback addFeedback(Feedback feedback) {
        checkCustomerExists(feedback.customerId);
        feedbackList.add(feedback);
        return feedback;
    }

    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

    public Feedback getFeedback(String id) {
        return feedbackList.stream()
                .filter(feedback -> id.equals(feedback.id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Feedback " + id + " not found"));
    }

    public Feedback updateFeedback(String id, Feedback updatedFeedback) {
        Feedback feedback = getFeedback(id);

        checkCustomerExists(updatedFeedback.customerId);

        feedback.message = updatedFeedback.message;
        feedback.customerId = updatedFeedback.customerId;

        return feedback;
    }

    public Map<String, String> deleteFeedback(String id) {
        feedbackList.remove(getFeedback(id));

        return Map.of("message", "Feedback " + id + " removed");
    }

    public ArrayList<Feedback> getCustomerFeedback(String id) {
        customerService.getCustomer(id);

        ArrayList<Feedback> result = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (id.equals(feedback.customerId)) {
                result.add(feedback);
            }
        }

        return result;
    }

    public Map<String, String> deleteCustomer(String id) {
        customerService.getCustomer(id);

        for (Feedback feedback : feedbackList) {
            if (id.equals(feedback.customerId)) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Delete this customer's feedback first.");
            }
        }

        customerService.removeCustomer(id);

        return Map.of("message", "Customer " + id + " removed");
    }

    private void checkCustomerExists(String customerId) {
        if (!customerService.customerExists(customerId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Cannot save feedback: customer does not exist.");
        }
    }
}