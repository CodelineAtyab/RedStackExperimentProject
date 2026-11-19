package com.redstack.reddesk_desk.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {
    @GetMapping(path="/profile")
    public Map<String,Object>getProfile(@RequestParam String name){
        List<Map<String,Object>> favorites = List.of(
                Map.of("id",1,"Title","Coffee"),
                Map.of("id",2,"Title","Books"),
                Map.of("id",3,"Title","Football")
        );
        return Map.of(
                "name",name,
                "favorites",favorites
        );
    }
}
