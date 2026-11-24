package com.teamred.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private CustomerService customerService;

    public List<Feedback> getAll() {
        return DataStore.feedbacks;
    }

    public Optional<Feedback> findById(String id) {
        return DataStore.feedbacks.stream()
                .filter(f -> f.getId() != null && f.getId().equals(id))
                .findFirst();
    }

    public Feedback add(Feedback feedback) {
        if (feedback.getCustomerId() == null
                || customerService.findById(feedback.getCustomerId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Customer with id '" + feedback.getCustomerId() + "' does not exist");
        }
        DataStore.feedbacks.add(feedback);
        return feedback;
    }
}