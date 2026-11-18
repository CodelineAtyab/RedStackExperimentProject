package com.redStack.unirestPractice.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/feedback")
public class feedbackController
{
    public record Feedback(Integer id, String name, String message) {}
    private List<Feedback> feedbackList = new ArrayList<>();
    private int counter = 1;

    @PostMapping
    public Feedback newFeedback(@RequestBody Feedback newFeedback){
        Feedback xx = new Feedback(counter++, newFeedback.name(), newFeedback.message());
        feedbackList.add(xx);
        return xx;
    }
    @GetMapping
    public List<Feedback> getfeedback(){
        return feedbackList;
    }
}
