package com.RedStack.ProfileServer;

/** One feedback item: {"id": 1, "name": "Mohammed", "message": "Great service"} */
public record Feedback(int id, String name, String message) {
}