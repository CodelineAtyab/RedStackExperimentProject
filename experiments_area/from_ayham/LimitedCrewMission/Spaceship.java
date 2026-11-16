import java.util.ArrayList;

public class Spaceship {
    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    public Spaceship(String name) {
        this.name = name;
        this.lifeSupport = new LifeSupport();
        this.crew = new ArrayList<>();
        System.out.println("[Spaceship] Building " + name + "...");
    }


    public void boardCrew(Astronaut astronaut) {
        if (astronaut == null) {
            System.out.println("Cannot board a null astronaut.");
            return;
        }
        else if (crew.size() < 3) {
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + name + " (seat " + crew.size() + " of 3)");
        } else {
            System.out.println(name + " is full: " + astronaut.getName() + " stays behind");
        }
    }

    public void printManifest() {
        System.out.println("Spaceship: " + name);
        System.out.print("Crew Members:");
        for (Astronaut astronaut : crew) {
            System.out.print(", " + astronaut.getName());
        }
        System.out.println();
    }
}
