package com.example.Feedback.CRUD.API;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private ArrayList<Feedback> feedbackList = new ArrayList<>();


    @GetMapping
    public ArrayList<Feedback> getFeedbacks(){
        return feedbackList;
    }


    @DeleteMapping("/{id}")

    public String DeleteFeedback(@PathVariable String id){


        for(Feedback feedbacks:feedbackList){
            if(feedbacks.getId().equals(id))
                feedbackList.remove(feedbacks);
            return "Feedback Deleted Successfully!!!";

        }
        return "Feedback wasn't found";

    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        feedbackList.add(feedback);
        return feedback;
    }


    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable String id,
                                   @RequestBody Feedback updatedFeedback) {

        for (Feedback feedback : feedbackList) {
            if (feedback.getId().equals(id)) {
                feedback.setMessage(updatedFeedback.getMessage());
                return feedback;
            }
        }

        return null;
    }
}
