package com.RedStack.ProfileServer;

import java.util.List;

public record Profile(String name, List<Favourite> favourites) {}