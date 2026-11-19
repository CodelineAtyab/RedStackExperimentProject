package com.example.ProfileServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public Map<String,Object> getProfile(@RequestParam String name) {


        return Map.of(
                "name", name,
                "favourites", List.of(
                        Map.of("id", 1, "title", "Coffee"),
                        Map.of("id", 2, "title", "Books"),
                        Map.of("id", 3, "title", "Football")
                )
        );
    }
}