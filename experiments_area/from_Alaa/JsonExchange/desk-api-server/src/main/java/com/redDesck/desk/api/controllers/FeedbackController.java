package com.redDesck.desk.api.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



// @RequestMapping sets the base path and content type for every method below,
// so each method only needs its own HTTP method annotation.
@RestController
@RequestMapping(path = "/feedback", produces = "application/json")
public class FeedbackController {

    // Response body for every "id does not exist" case.
    // Defined once so PUT and DELETE always return the same text.
    private static final String NOT_FOUND_BODY = "{\"error\":\"not found\"}";

    // In-memory storage. The data is lost when the server stops (no database in this task).
    private final List<JSONObject> feedbackList = new ArrayList<>();

    /* The next id to hand out. Starts at 1 and only goes up,
        so a deleted id is never reused.*/
    private int nextId = 1;


    // method POST to create and pass feedback
    @PostMapping
    public ResponseEntity<String> createFeedback(@RequestBody String body) {// Body example: {"name":"Sara","message":"Great service"}.
        // Parse the text into a JSONObject so we can add the id.
        // The client does not send an id, the server creates it.
        JSONObject newFeedback = new JSONObject(body);
        newFeedback.put("id", nextId);
        nextId++;
        feedbackList.add(newFeedback);

        // 201 Created is the usual status for a successful POST that creates something.
        return ResponseEntity.status(201).body(newFeedback.toString());
    }


    @GetMapping
    public ResponseEntity<String> getAllFeedback() {
        // The JSONArray constructor accepts the whole list, so no loop is needed.
        return ResponseEntity.ok(new JSONArray(feedbackList).toString());
    }


    //updating the message by finding the id of feedback
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFeedback(@PathVariable int id, @RequestBody String body) {
        for (JSONObject feedback : feedbackList) {
            if (feedback.getInt("id") == id) {
                // The body must contain the key "message", spelled exactly like this.
                // Known gap: a missing "message" key causes a 500 error.
                JSONObject updateData = new JSONObject(body);
                feedback.put("message", updateData.getString("message"));
                return ResponseEntity.ok(feedback.toString());
            }
        }
        // The loop ended without a match, so the id does not exist.
        return ResponseEntity.status(404).body(NOT_FOUND_BODY);
    }


    //DELETE feedback by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable int id) {
        for (JSONObject feedback : feedbackList) {
            if (feedback.getInt("id") == id) {
                // Safe to remove inside the loop because we return right after.
                // Removing and then continuing the loop would throw a ConcurrentModificationException.
                feedbackList.remove(feedback);
                return ResponseEntity.ok("{\"message\":\"deleted\"}");
            }
        }
        return ResponseEntity.status(404).body(NOT_FOUND_BODY);
    }

}