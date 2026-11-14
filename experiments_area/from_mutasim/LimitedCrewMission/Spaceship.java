import java.util.ArrayList;

public class Spaceship {

    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;
    private static final int SEAT_CAPACITY = 3;

    public Spaceship(String shipName) {
        this.name = shipName;
        System.out.println("[Spaceship] Building " + name + "...");

        // Composition: the spaceship builds and owns its life support.
        lifeSupport = new LifeSupport();
        crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut crewMember) {
        if (crewMember == null) {
            System.out.println(name + ": no astronaut to board");
        } else if (crew.size() < SEAT_CAPACITY) {
            crew.add(crewMember);
            System.out.println("Boarded " + crewMember.getName() + " on " + name
                    + " (seat " + crew.size() + " of " + SEAT_CAPACITY + ")");
        } else {
            System.out.println(name + " is full: " + crewMember.getName() + " stays behind");
        }
    }

    public void printManifest() {
        System.out.print(name + " crew: ");

        if (crew.isEmpty()) {
            System.out.println("none");
        } else {
            for (int index = 0; index < crew.size(); index++) {
                System.out.print(crew.get(index).getName());

                if (index < crew.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}