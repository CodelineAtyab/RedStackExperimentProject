package com.reddesk.desk_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping(path = "/greet")
    String greet() {
        return "Hello Team RED STACK !!!!";
    }

    @GetMapping(path = "/notify")
    String notifyTeam() {
        return "This is a critical time...";
    }
}
