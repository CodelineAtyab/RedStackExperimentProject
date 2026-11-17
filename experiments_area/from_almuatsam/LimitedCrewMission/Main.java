public class Main {

    public static void main(String[] args) {
        // Why Astronaut can never have more than four objects:
        // The constructor is private, so nobody outside the class can write
        // "new Astronaut(...)". The only way to get an astronaut is recruit(),
        // and recruit() checks the static recruitedCount before creating one.
        // The counter is shared by the whole class, so once it reaches 4,
        // recruit() refuses and returns null instead of building a fifth object.

        // Part A: recruit five astronauts (the fifth is rejected and returns null)
        Astronaut a1 = Astronaut.recruit("Noor");
        Astronaut a2 = Astronaut.recruit("Sara");
        Astronaut a3 = Astronaut.recruit("Omar");
        Astronaut a4 = Astronaut.recruit("Zaid");
        Astronaut a5 = Astronaut.recruit("Hana");

        // Part B: build Falcon, board everyone, print manifest, then discard the ship
        Spaceship falcon = new Spaceship("Falcon");
        falcon.boardCrew(a1);
        falcon.boardCrew(a2);
        falcon.boardCrew(a3);
        falcon.boardCrew(a4);
        falcon.boardCrew(a5);
        falcon.printManifest();
        falcon = null;

        // Part C: build Comet with two astronauts from the original pool
        Spaceship comet = new Spaceship("Comet");
        comet.boardCrew(a3);
        comet.boardCrew(a4);
        comet.printManifest();

        // Composition vs aggregation:
        // Spaceship and LifeSupport use composition. The ship creates its own
        // LifeSupport inside its constructor and nobody else holds it, so the
        // life support belongs to the ship and goes away with it.
        // Spaceship and Astronaut use aggregation. Astronauts are created outside
        // the ship (by recruit()) and only passed in, so the ship just keeps
        // references to them. Astronauts exist before the ship and after it,
        // which is why Omar can still join Comet after Falcon is set to null.

        // Part D: prove aggregation
        System.out.println("Omar is still here: " + a3.getName());
        System.out.println("Recruited so far: " + Astronaut.getRecruitedCount());
    }
}
