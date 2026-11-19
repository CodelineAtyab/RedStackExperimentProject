package com.redstack.ProfileServer;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @GetMapping("/profile")
    public Profile getProfile(@RequestParam String name) {
        return new Profile(
                name,
                List.of(new Favourite(1, "Coffee"), new Favourite(2, "Comics"), new Favourite(3, "Tennis"))
        );
    }

    public record Profile(String name, List<Favourite> favourites) {}
    public record Favourite(int id, String title) {}
}
