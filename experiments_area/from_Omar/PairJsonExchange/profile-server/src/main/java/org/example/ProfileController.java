package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public ProfileResponse getProfile(@RequestParam(defaultValue = "Omar") String name) {
        List<Favourite> favourites = List.of(
                new Favourite(1, "Gaming"),
                new Favourite(2, "Java"),
                new Favourite(3, "Football")
        );
        return new ProfileResponse(name, favourites);
    }
}