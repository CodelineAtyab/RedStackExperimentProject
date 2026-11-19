package com.almuatsam.profileserver.model;

import java.util.List;

public record Profile(String name, List<Favourite> favourites) {
}
