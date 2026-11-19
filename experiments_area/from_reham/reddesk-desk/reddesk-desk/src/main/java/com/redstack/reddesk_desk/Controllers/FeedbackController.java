package com.redstack.reddesk_desk.Controllers;
import java.util.ArrayList;

import com.redstack.reddesk_desk.Feedback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping("/feedback")
    public ArrayList<Feedback> getFeedbacks(){
        return feedbacks;
    }

    @PutMapping("/feedback/{id}")
    public Feedback updateFeedback(
            @PathVariable int id,
            @RequestBody Feedback updateFeedback
    ){
        for(Feedback feedback:feedbacks){
            if (feedback.id != null && feedback.id == id){
                feedback.message=updateFeedback.message;
                return feedback;
            }
        }
        return null;

    }

    @DeleteMapping("/feedback/{id}")
    public String deleteFeedback(@PathVariable int id) {

        for (Feedback feedback : feedbacks) {

            if (feedback.id != null && feedback.id == id) {
                feedbacks.remove(feedback);
                return "Feedback deleted successfully";
            }
        }

        return "Feedback not found";
    }
}

