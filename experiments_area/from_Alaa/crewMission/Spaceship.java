
import java.util.ArrayList;

public class Spaceship {

    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    public Spaceship(String name) {
        this.name = name;
        System.out.println("[Spaceship] Building " + name + "...");

        // life support will only be installed once the spaceship is created
        this.lifeSupport = new LifeSupport(); //composition

        // Create an empty crew list
        this.crew = new ArrayList<>(); //Aggregation
    }

    public void boardCrew(Astronaut astronaut){
        if (astronaut == null){
            System.out.println(this.name + ": no astronaut to board");
        } else if (crew.size() < 3) { // Allow a maximum of 3 astronauts to board
            crew.add(astronaut);
            System.out.println("Boarded " + astronaut.getName() + " on " + this.name + "(seat " + crew.size() + " of 3)" );
        } else {
            System.out.println(this.name + " is full " + astronaut.getName() + " stays behind");
        }
    }

    public void printManifest(){
        System.out.print(this.name + " crew: ");
        if (crew.isEmpty()) {
            System.out.println("none");
            return; // Exit the method early if the crew list is empty
        }
        for (int i = 0; i < crew.size(); i++) {
            System.out.print( " , " + crew.get(i).getName());
        }
        System.out.println();
    }
    
}
