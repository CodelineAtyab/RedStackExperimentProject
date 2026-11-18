package org.redstack.pairjsonserver;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProfileController {

    @GetMapping("/profile")
    public Profile profile(@RequestParam(defaultValue = "Guest") String name) {
        return new Profile(name, List.of (
                new Favorite(1, "CodeLine"),
                new Favorite(2, "Rihal"),
                new Favorite(3, "Chai Fatima")
        ));
    }
}
