package com.RedStack.ProfileServer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final List<Feedback> feedbacks = new CopyOnWriteArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);


    @PostMapping
    public ResponseEntity<Feedback> create(@RequestBody Feedback body) {
        Feedback created = new Feedback(nextId.getAndIncrement(), body.name(), body.message());
        feedbacks.add(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created); // 201
    }


    @GetMapping
    public List<Feedback> getAll() {
        return feedbacks;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Feedback body) {
        for (int i = 0; i < feedbacks.size(); i++) {
            Feedback old = feedbacks.get(i);
            if (old.id() == id) {
                Feedback updated = new Feedback(id, old.name(), body.message());
                feedbacks.set(i, updated);
                return ResponseEntity.ok(updated); // 200
            }
        }
        return notFound(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        boolean removed = feedbacks.removeIf(f -> f.id() == id);
        if (removed) {
            return ResponseEntity.ok(Map.of("deleted", id)); // 200
        }
        return notFound(id);
    }

    private ResponseEntity<Object> notFound(int id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Feedback with id " + id + " not found"));
    }
}