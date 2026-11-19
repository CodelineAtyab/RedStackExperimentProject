// .\mvnw.cmd spring-boot:run

package com.example.pairJSON;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientReceiverController {

    @GetMapping("/profile")
    public Profile getProfile(@RequestParam String name) {
        return new Profile(name, List.of(
                new Favourite(1, "Red Stack"),
                new Favourite(2, "Junior Java developer"),
                new Favourite(3, "JSON serialization and deserialization")
        ));
    }

    public record Profile(String name, List<Favourite> favourites) {
    }

    public record Favourite(int id, String title) {
    }
}
