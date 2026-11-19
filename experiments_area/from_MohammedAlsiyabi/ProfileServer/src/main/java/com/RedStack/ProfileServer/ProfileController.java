package com.RedStack.ProfileServer;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public Profile getProfile(@RequestParam(defaultValue = "Guest") String name) {
        return new Profile(name, List.of(
                new Favourite(1, "Tea"),
                new Favourite(2, "Books"),
                new Favourite(3, "Football")));
    }
}