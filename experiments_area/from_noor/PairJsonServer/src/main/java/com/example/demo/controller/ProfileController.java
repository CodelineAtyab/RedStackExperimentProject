package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProfileController {
    @GetMapping("/profile")
    public Map<String, Object> getProfile(@RequestParam String name) {

        return Map.of(
                "name", name,
                "favourites", List.of(
                        Map.of("id", 1, "title", "Coffee"),
                        Map.of("id", 2, "title", "Books"),
                        Map.of("id", 3, "title", "Coding")
                )
        );
    }
}
