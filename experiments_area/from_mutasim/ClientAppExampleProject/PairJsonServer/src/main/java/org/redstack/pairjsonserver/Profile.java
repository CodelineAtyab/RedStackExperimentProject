package org.redstack.pairjsonserver;

import java.util.List;

public record Profile(String name, List<Favorite> Favorite) {}
