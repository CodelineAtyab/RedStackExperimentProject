package com.server.desk.api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Profile {
    public record Favourite(int id, String title) {}
    public record Greeting(String name, List<Favourite> favourites) { }

    @GetMapping("/profile")
    Greeting profile(String name){
        List<Favourite> favouritesList = List.of(
                new Favourite(1, "Coffee"),
                new Favourite(2, "Books"),
                new Favourite(3, "Football")
        );
        return new Greeting(name,favouritesList);
    }
}
