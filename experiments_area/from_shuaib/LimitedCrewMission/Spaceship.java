import java.util.ArrayList;

public class Spaceship {
    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;
    private static final int CAPACITY = 3;

    public Spaceship(String name) {
        this.name = name;
        System.out.println("[Spaceship] Building " + name + "...");
        this.lifeSupport = new LifeSupport();
        this.crew = new ArrayList<>();
    }

    public void boardCrew(Astronaut astronaut){
        if(astronaut == null){
            System.out.println(name + ": no astronaut to board");
        } else if (crew.size() < CAPACITY) {
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + name + " (seat " + crew.size() + " of 3)");
        } else{
            System.out.println(name + "is full: " + astronaut.getName() + " stays behind");
        }
    }

    public void printManifest() {
        System.out.print(name + " crew: ");
        if (crew.isEmpty()) {
            System.out.println("none");
        } else {
            for (int i = 0; i < crew.size(); i++) {
                System.out.print(crew.get(i).getName());
                if (i < crew.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}