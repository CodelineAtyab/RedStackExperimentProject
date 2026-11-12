import java.util.ArrayList;

public class Spaceship {

    private static final int MAX_SEATS = 3;

    private String name;
    private LifeSupport lifeSupport;   // Composition: the ship creates and owns it
    private ArrayList<Astronaut> crew; // Aggregation: astronauts exist independently

    public Spaceship(String name) {
        this.name = name;
        System.out.println("[Spaceship] Building " + name + "...");
        this.lifeSupport = new LifeSupport();
        this.crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut) {
        if (astronaut == null) {
            System.out.println(name + ": no astronaut to board");
        } else if (crew.size() < MAX_SEATS) {
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + name
                    + " (seat " + crew.size() + " of " + MAX_SEATS + ")");
        } else {
            System.out.println(name + " is full: " + astronaut.getName() + " stays behind");
        }
    }

    public void printManifest() {
        if (crew.isEmpty()) {
            System.out.println(name + " crew: none");
            return;
        }
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
