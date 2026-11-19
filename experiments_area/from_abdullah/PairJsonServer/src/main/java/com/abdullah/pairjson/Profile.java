package com.abdullah.pairjson;

import java.util.ArrayList;

public class Profile {
    private String name;
    private ArrayList<Favourite> favourites;

    public Profile(String name, ArrayList<Favourite> favourites) {
        this.name = name;
        this.favourites = favourites;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Favourite> getFavourites() {
        return favourites;
    }
}
