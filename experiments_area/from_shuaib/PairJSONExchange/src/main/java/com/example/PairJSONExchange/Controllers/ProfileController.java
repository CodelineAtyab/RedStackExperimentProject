package com.example.PairJSONExchange.Controllers;

import com.example.PairJSONExchange.FavoriteItem;
import com.example.PairJSONExchange.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProfileController {

    @GetMapping(path = "/profile")
    public Profile getProfile(@RequestParam(value = "name", defaultValue = "Sara") String name) {
        List<FavoriteItem> favourites = Arrays.asList(
                new FavoriteItem(1, "Coffee"),
                new FavoriteItem(2, "Books"),
                new FavoriteItem(3, "Football")
        );
        return new Profile(name, favourites);
    }
}