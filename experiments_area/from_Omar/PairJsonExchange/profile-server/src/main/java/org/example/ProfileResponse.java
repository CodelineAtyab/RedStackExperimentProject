package org.example;

import java.util.List;

public record ProfileResponse(String name, List<Favourite> favourites) {
}