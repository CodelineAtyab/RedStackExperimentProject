package org.example;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList= new ArrayList<>();

    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    public List<Feedback> getAllFeedback(){
        return feedbackList;
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback incoming){
        long newId = idCounter.getAndIncrement();
        Feedback saved = new Feedback(newId, incoming.name(), incoming.message());
        feedbackList.add(saved);
        return saved;


    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable long id, @RequestBody Feedback incoming) {
        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback current = feedbackList.get(i);
            if (current.id() == id) {
                Feedback updated = new Feedback(id, current.name(), incoming.message());
                feedbackList.set(i, updated);
                return updated;
            }
        }
        throw new RuntimeException("Feedback item with ID " + id + " not found.");
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable long id) {
        boolean removed = feedbackList.removeIf(f -> f.id() == id);
        if (removed) {
            return "Successfully deleted feedback with ID: " + id;
        }
        return "Feedback item with ID " + id + " not found.";
    }
    }
