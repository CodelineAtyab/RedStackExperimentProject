package com.redstack.reddesk_desk.Controllers;
import java.util.ArrayList;

import com.redstack.reddesk_desk.Feedback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeedbackController {
    //to store the feedback
    private ArrayList<Feedback> feedbacks = new ArrayList<>();

    private int nextId=1;

    //Create -POST
    @PostMapping("/feedback")

    public Feedback addFeedback(@RequestBody Feedback feedback){
        Feedback newFeedback = new Feedback(
                nextId,
                feedback.name,
                feedback.message
        );
        nextId++;
        feedbacks.add(newFeedback);
        System.out.println(newFeedback);

        return newFeedback;

    }
}

