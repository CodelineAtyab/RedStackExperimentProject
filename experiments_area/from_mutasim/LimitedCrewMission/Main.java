public class Main {

    public static void main(String[] args) {

        /* Astronaut's constructor is private, so recruitment is the only way to
        create one. The shared static counter prevents a fifth object. */
        Astronaut noor = Astronaut.recruit("Noor");
        Astronaut sara = Astronaut.recruit("Sara");
        Astronaut omar = Astronaut.recruit("Omar");
        Astronaut zaid = Astronaut.recruit("Zaid");
        Astronaut hana = Astronaut.recruit("Hana");

        // Composition: each Spaceship creates and owns its LifeSupport.
        // Aggregation: astronauts are created separately and can board other ships.
        Spaceship falcon = new Spaceship("Falcon");
        falcon.boardCrew(noor);
        falcon.boardCrew(sara);
        falcon.boardCrew(omar);
        falcon.boardCrew(zaid);
        falcon.boardCrew(hana);
        falcon.printManifest();
        falcon = null;

        Spaceship comet = new Spaceship("Comet");
        comet.boardCrew(omar);
        comet.boardCrew(zaid);
        comet.printManifest();

        System.out.println("Omar is still here: " + omar.getName());
        System.out.println("Recruited so far: " + Astronaut.getRecruitedCount());
    }
}