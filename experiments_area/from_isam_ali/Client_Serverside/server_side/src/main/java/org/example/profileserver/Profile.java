package org.example.profileserver;

import java.util.List;

public record Profile(String name, List<Favorite> Favorite) {}
