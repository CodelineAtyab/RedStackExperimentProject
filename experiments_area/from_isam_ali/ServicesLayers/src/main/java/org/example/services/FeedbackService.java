package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private CustomerService customerService;

    private final List<Feedback> feedbackList = new ArrayList<>();

    // Used by the controller to refuse feedback for a customer that does not exist
    public boolean customerExists(String customerId) {
        return customerService.getOne(customerId).isPresent();
    }

    public List<Feedback> getAll() {
        return feedbackList;
    }

    public Optional<Feedback> getOne(String id) {
        return feedbackList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    public List<Feedback> getByCustomerId(String customerId) {
        return feedbackList.stream()
                .filter(f -> customerId.equals(f.getCustomerId()))
                .toList();
    }

    public Feedback create(Feedback feedback) {
        feedbackList.add(feedback);
        return feedback;
    }

    public Optional<Feedback> update(String id, Feedback updated) {
        for (int i = 0; i < feedbackList.size(); i++) {
            if (feedbackList.get(i).getId().equals(id)) {
                updated.setId(id);
                feedbackList.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }

    public boolean deleteOne(String id) {
        return feedbackList.removeIf(f -> f.getId().equals(id));
    }
}
