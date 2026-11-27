package com.noor.employeesapi.service;

import com.noor.employeesapi.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    private final List<Feedback> feedbackList = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    public Feedback getFeedbackById(String id) {
        for (Feedback feedback : feedbackList) {
            if (feedback.getId().equals(id)) {
                return feedback;
            }
        }
        return null;
    }

    public Feedback addFeedback(Feedback feedback) {

        if (customerService.getCustomerById(feedback.getCustomerId()) == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Customer not found");
        }

        if (getFeedbackById(feedback.getId()) != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Feedback already exists");
        }

        feedbackList.add(feedback);
        return feedback;
    }

    public Feedback updateFeedback(String id, Feedback updated) {

        if (customerService.getCustomerById(updated.getCustomerId()) == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Customer not found");
        }

        Feedback feedback = getFeedbackById(id);

        if (feedback != null) {
            feedback.setCustomerId(updated.getCustomerId());
            feedback.setMessage(updated.getMessage());
            feedback.setRating(updated.getRating());
        }

        return feedback;
    }

    public boolean deleteFeedback(String id) {
        Feedback feedback = getFeedbackById(id);

        if (feedback != null) {
            feedbackList.remove(feedback);
            return true;
        }

        return false;
    }

    public List<Feedback> getFeedbackByCustomer(String customerId) {

        if (customerService.getCustomerById(customerId) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer not found");
        }

        List<Feedback> result = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (feedback.getCustomerId().equals(customerId)) {
                result.add(feedback);
            }
        }

        return result;
    }
}