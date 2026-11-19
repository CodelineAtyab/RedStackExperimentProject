package com.redDesck.desk.api.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping(value = "/profile", produces = "application/json")
     String getProfile(@RequestParam String name) {

        // first we create three JSON objects that include id +
        JSONObject item1 = new JSONObject();
        item1.put("id", 1);
        item1.put("title", "Cafe");

        JSONObject item2 = new JSONObject();
        item2.put("id", 2);
        item2.put("title", "Pilates");

        JSONObject item3 = new JSONObject();
        item3.put("id", 3);
        item3.put("title", "Matcha");

        // 2. Put them into a JSONArray
        JSONArray favouritesArray = new JSONArray();
        favouritesArray.put(item1);
        favouritesArray.put(item2);
        favouritesArray.put(item3);

        // 3. Create the main JSONObject
        JSONObject mainObject = new JSONObject();
        mainObject.put("name", name);
        mainObject.put("favourites", favouritesArray);

        // 4. Return as a JSON String
        return mainObject.toString();
    }
}