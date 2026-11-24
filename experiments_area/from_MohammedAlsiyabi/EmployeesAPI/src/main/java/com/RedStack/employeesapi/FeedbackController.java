package com.teamred.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable String id) {
        return feedbackService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.add(feedback);
    }
}