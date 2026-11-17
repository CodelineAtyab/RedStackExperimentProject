import java.util.ArrayList;

public class Spaceship {

    public Spaceship(String name) {
        this.name = name;
        System.out.println("[Spaceship] Building " + name + "...");
        this.lifeSupport = new LifeSupport();
        this.crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut) {
        if (astronaut == null) {
            System.out.println(name + ": no astronaut to board");
        } else if (crew.size() < 3) {
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + name + " (seat " + crew.size() + " of 3)");
        } else {
            System.out.println(name + " is full: " + astronaut.getName() + " stays behind");
        }
    }

    public void printManifest() {
        System.out.print(name + " crew: ");

        if (crew.isEmpty()) {
            System.out.println("none");
            return;
        }

        for (Astronaut astronaut : crew) {
            System.out.print(astronaut.getName() + ", ");
        }

        System.out.println();
    }

    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;
}