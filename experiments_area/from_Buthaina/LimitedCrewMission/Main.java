package com.LimitedCrewMission;
public class Main {

    public static void main(String[] args) {

        // Recruit five astronauts (maximum is four)
        Astronaut a1 = Astronaut.recruit("Noor");
        Astronaut a2 = Astronaut.recruit("Sara");
        Astronaut a3 = Astronaut.recruit("Omar");
        Astronaut a4 = Astronaut.recruit("Zaid");
        Astronaut a5 = Astronaut.recruit("Hana");

        // Build Falcon spaceship
        Spaceship falcon = new Spaceship("Falcon");

        // Board astronauts onto Falcon
        falcon.boardCrew(a1);
        falcon.boardCrew(a2);
        falcon.boardCrew(a3);
        falcon.boardCrew(a4);
        falcon.boardCrew(a5);

        // Print Falcon crew
        falcon.printManifest();

        // Remove Falcon reference
        falcon = null;

        // Build another spaceship
        Spaceship comet = new Spaceship("Comet");

        // Board the same astronauts onto Comet
        comet.boardCrew(a3);
        comet.boardCrew(a4);

        // Print Comet crew
        comet.printManifest();

        // Check that Omar still exists
        System.out.println("Omar is still here: " + a3.getName());

        // Display total recruited astronauts
        System.out.println(
                "Recruited so far: " + Astronaut.getRecruitedCount()
        );
    }
}
