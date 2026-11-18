package com.abdullah.pairjson;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @GetMapping("/profile")
    public Profile getProfile(@RequestParam("name") String name) {
        ArrayList<Favourite> favourites = new ArrayList<>();
        favourites.add(new Favourite(1, "Coffee"));
        favourites.add(new Favourite(2, "Books"));
        favourites.add(new Favourite(3, "Football"));
        return new Profile(name, favourites);
    }
}
