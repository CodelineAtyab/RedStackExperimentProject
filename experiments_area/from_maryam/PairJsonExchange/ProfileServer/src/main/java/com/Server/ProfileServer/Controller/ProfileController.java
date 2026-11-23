package com.Server.ProfileServer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//http:localhost:8080/profile?name=Maryam
@RestController
public class ProfileController {

    // @GetMapping("/profile")>>> must be same with my partner
    @GetMapping("/profile")
    public Map<String, Object> getProfile(@RequestParam String name) {

        List<Map<String, Object>> favourites = List.of(
                Map.of("id", 1, "title", "Coffee"),
                Map.of("id", 2, "title", "Books"),
                Map.of("id", 3, "title", "Football")
        );

        Map<String, Object> profile = Map.of(
                "name", name,
                "favourites", favourites
        );

        return profile;
    }
}
