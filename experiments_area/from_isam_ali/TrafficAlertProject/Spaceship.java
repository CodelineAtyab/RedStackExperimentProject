import java.util.ArrayList;

public class Spaceship {
    private static final int SEATS = 3;
    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    public Spaceship(String name) {
        this.name = name;
        System.out.println("[Spaceship] Building " + name + "...");
        this.lifeSupport = new LifeSupport();
        this.crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut) {
        if (astronaut == null) {
            System.out.println(name+ ": no astronaut on board!");
        } else if (crew.size() < SEATS) {
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + name + " (seat "+ crew.size() + " of " + SEATS + ")");
        } else {
            System.out.println(name + " is full " + astronaut.getName() + "stays behind");
        }
    }
    public void printManifest() {
        String names = "";
        for (int i = 0; i < crew.size(); i++) {
            if (i > 0) {
                names += ", ";
            }
            names += crew.get(i).getName();
        }
        if (crew.isEmpty()) {
            names = "none";
        }
        System.out.println(name + " crew: " + names);
    }

}