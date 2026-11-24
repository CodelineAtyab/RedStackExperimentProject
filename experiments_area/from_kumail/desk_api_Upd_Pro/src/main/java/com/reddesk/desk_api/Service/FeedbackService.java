
package com.reddesk.desk_api.Service;

import com.reddesk.desk_api.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FeedbackService {

    private ArrayList<Feedback> feedbackList = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public Feedback addFeedback(Feedback feedback) {

        boolean customerExists = customerService
                .getCustomerById(feedback.customerId)
                .isPresent();

        if (!customerExists) {
            throw new IllegalArgumentException(
                    "Customer not found: " + feedback.customerId
            );
        }

        feedbackList.add(feedback);

        return feedback;
    }

    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackList.stream()
                .filter(feedback -> feedback.id.equals(id))
                .findFirst();
    }
}
