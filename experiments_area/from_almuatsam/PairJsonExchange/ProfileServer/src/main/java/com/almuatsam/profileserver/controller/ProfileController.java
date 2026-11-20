package com.almuatsam.profileserver.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almuatsam.profileserver.model.Favourite;
import com.almuatsam.profileserver.model.Profile;

@RestController
public class ProfileController {

	@GetMapping("/profile")
	public Profile getProfile(@RequestParam String name) {
		List<Favourite> favourites = List.of(
				new Favourite(1, "Java"),
				new Favourite(2, "Spring Boot"),
				new Favourite(3, "JSON"));
		return new Profile(name, favourites);
	}

}
