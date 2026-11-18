package com.server.desk_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Profile {

    public record FavouriteList(int id, String title) {}
    public record ProfileFavName(String name, List<FavouriteList> favourites) { }

    @GetMapping("/profile")
    ProfileFavName Profile(String name){
        List<FavouriteList> favourite = List.of(
                new FavouriteList(1, "Coffee"),
                new FavouriteList(2, "Books"),
                new FavouriteList(3, "Football")
        );
        return new ProfileFavName(name, favourite);
    }

}
