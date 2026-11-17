package com.example.PairJSONExchange;

import java.util.List;

public class Profile {
    private String name;
    private List<FavoriteItem> favourites;

    public Profile(String name, List<FavoriteItem> favourites) {
        this.name = name;
        this.favourites = favourites;
    }

    public List<FavoriteItem> getFavourites() {
        return favourites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavourites(List<FavoriteItem> favourites) {
        this.favourites = favourites;
    }
}