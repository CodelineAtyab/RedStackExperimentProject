package com.example.PairJSONExchange;

public class Profile {
    private String name;
    private List <FavoriteItem> favorite;

    public Profile(String name, List<FavoriteItem> favorite) {
        this.name = name;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public List<FavoriteItem> getFavorite() {
        return favorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavorite(List<FavoriteItem> favorite) {
        this.favorite = favorite;
    }
}