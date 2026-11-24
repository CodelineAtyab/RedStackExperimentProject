package com.profileServer.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class ProfileController {
    @GetMapping("/profile")
    public Map<String,Object> getProfile(@RequestParam String name){
        List<Map<String ,Object>> favourites = List.of(
                Map.of("id" ,1,"title","Sleep"),
                Map.of("id" ,2,"title","Dance"),
                Map.of("id" ,3,"title","Books")

        );
        return Map.of(
                "name",name,
                "favourites" ,favourites
        );
    }
}
