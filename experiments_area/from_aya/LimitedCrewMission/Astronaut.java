package com.LimitedCrewMission;

public class Astronaut {
    private String name;
    private static final int MAX_ASTRONAUTS = 4;
    private static int recruitedCount = 0;

    private Astronaut(String name) {
        this.name = name;
    }

    public static Astronaut recruit(String name) {

        if (recruitedCount < MAX_ASTRONAUTS) {

            recruitedCount++;

            System.out.println("Recruited astronaut #" + recruitedCount + ": " + name);

            Astronaut astronaut = new Astronaut(name);

            return astronaut;

        } else {

            System.out.println("Crew is full: cannot recruit " + name);

            return null;
        }
    }

    public static int getRecruitedCount() {
        return recruitedCount;
    }

    public String getName() {
        return name;
    }
}
