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

    @PutMapping(path = "/{id}")
    public Feedback update(@PathVariable int id,@RequestBody Feedback newFeedback){
        for (int i = 0; i < feedbackList.size(); i++) {
            if(feedbackList.get(i).id().equals(id)){
                Feedback xx = new Feedback(feedbackList.get(i).id(), feedbackList.get(i).name(), newFeedback.message());
                feedbackList.set(i,xx);
                return xx;
            }
        }return null;
    }
    @DeleteMapping(path = "/{id}")
    public List<Feedback> delete(@PathVariable int id) {
        for (int i = 0; i < feedbackList.size(); i++) {
            if(feedbackList.get(i).id().equals(id)){
                feedbackList.remove(i);
                return feedbackList;
            }
        }
        return null;
    }
}

