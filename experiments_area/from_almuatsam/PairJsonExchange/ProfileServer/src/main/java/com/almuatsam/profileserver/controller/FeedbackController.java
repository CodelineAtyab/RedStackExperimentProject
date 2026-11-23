package com.almuatsam.profileserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.almuatsam.profileserver.model.Feedback;

@RestController
public class FeedbackController {

	private final List<Feedback> feedbackList = new ArrayList<>();
	private int nextId = 1;

	@GetMapping("/feedback")
	public List<Feedback> getAllFeedback() {
		return feedbackList;
	}

	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback request) {
		Feedback created = new Feedback(nextId++, request.name(), request.message());
		feedbackList.add(created);
		return created;
	}

	@PutMapping("/feedback/{id}")
	public Feedback updateFeedback(@PathVariable int id, @RequestBody Feedback request) {
		for (int i = 0; i < feedbackList.size(); i++) {
			Feedback existing = feedbackList.get(i);
			if (existing.id() == id) {
				Feedback updated = new Feedback(existing.id(), existing.name(), request.message());
				feedbackList.set(i, updated);
				return updated;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found: id=" + id);
	}

	@DeleteMapping("/feedback/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFeedback(@PathVariable int id) {
		boolean removed = feedbackList.removeIf(feedback -> feedback.id() == id);
		if (!removed) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found: id=" + id);
		}
	}

}
