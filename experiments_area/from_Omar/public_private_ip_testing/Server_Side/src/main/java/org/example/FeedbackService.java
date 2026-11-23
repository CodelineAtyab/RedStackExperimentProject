package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private CustomerService customerService;

    private final List<Feedback> feedbackList = new ArrayList<>();

    public List<Feedback> getAll() {
        return feedbackList;
    }

    public Optional<Feedback> findById(String id) {
        return feedbackList.stream()
                .filter(f -> f.id().equals(id))
                .findFirst();
    }

    public Optional<Feedback> create(Feedback feedback) {
        if (feedback.customerId() == null || customerService.findById(feedback.customerId()).isEmpty()) {
            return Optional.empty();
        }
        feedbackList.add(feedback);
        return Optional.of(feedback);
    }
}