public class Main {
    public static void main(String[] args) {

        // Recruit astronauts (maximum 4)
        Astronaut a1 = Astronaut.recruit("Noor");
        Astronaut a2 = Astronaut.recruit("Sara");
        Astronaut a3 = Astronaut.recruit("Omar");
        Astronaut a4 = Astronaut.recruit("Zaid");
        Astronaut a5 = Astronaut.recruit("Hana");

        // Composition: Spaceship creates its own LifeSupport
        // Aggregation: Astronauts exist independently of Spaceship
        Spaceship falcon = new Spaceship("Falcon");

        falcon.boardCrew(a1);
        falcon.boardCrew(a2);
        falcon.boardCrew(a3);
        falcon.boardCrew(a4);
        falcon.boardCrew(a5);

        falcon.printManifest();

        // Remove the ship reference
        falcon = null;

        Spaceship comet = new Spaceship("Comet");

        comet.boardCrew(a3);
        comet.boardCrew(a4);

        comet.printManifest();

        System.out.println("Omar is still here: " + a3.getName());
        System.out.println("Recruited so far: "
                + Astronaut.getRecruitedCount());
    }
}