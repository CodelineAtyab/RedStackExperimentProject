package com.redstack.ProfileServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class profile {
    public record Favourite(int id, String title) {}
    public record GreetFile(String name, List<Favourite> favourites) { }

    @GetMapping("/profile")
    GreetFile profiles(String name){
        List<Favourite> favouriteList = List.of(
                new Favourite(1, "Coding"),
                new Favourite(2, "Anime"),
                new Favourite(3, "Games")
        );
        return new GreetFile(name,favouriteList);
    }
}
