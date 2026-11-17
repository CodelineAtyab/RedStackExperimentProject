

package com.LimitedCrewMission;

import java.util.ArrayList;

public class Spaceship {

    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    private static final int MAX_CREW = 3;

    public Spaceship(String name) {

        this.name = name;

        System.out.println("[Spaceship] Building " + name + "...");

        // Composition: spaceship creates its own life support
        this.lifeSupport = new LifeSupport();

        // Store astronauts through aggregation
        this.crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut) {

        if (astronaut == null) {
            System.out.println(name + ": no astronaut to board");
            return;
        }

        if (crew.size() >= MAX_CREW) {
            System.out.println(
                    name + " is full: " + astronaut.getName() + " stays behind"
            );
            return;
        }

        crew.add(astronaut);

        System.out.println(
                "Boarded " + astronaut.getName() + " on " + name
                        + " (seat " + crew.size() + " of " + MAX_CREW + ")"
        );
    }

    public void printManifest() {

        System.out.print(name + " crew: ");

        for (int i = 0; i < crew.size(); i++) {

            System.out.print(crew.get(i).getName());

            if (i < crew.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
