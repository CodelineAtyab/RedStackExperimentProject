import java.util.ArrayList;

public class Spaceship {

    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    public Spaceship(String name) {
                lifeSupport = new LifeSupport();

        System.out.printf("[Spaceship] Building %s\n", name);
        this.name=name;
        crew = new ArrayList<>();

    }

    public void boardCrew(Astronaut astronaut) {

        if (astronaut == null)
            System.out.printf("%s: no astronaut to board\n", "null");
        else if (crew.size() < 3) {
            crew.add(astronaut);

            System.out.printf("Boarded %s on %s (seat %d of 3)\n", astronaut.getName(),name, crew.size());
        } else if (crew.size() == 3)
            System.out.printf("%s is full: %s stays behind\n", name, astronaut.getName());

    }

    public void printManifest() {
        if (crew.isEmpty())
            System.out.println("none\n");

        else{
            System.out.printf("%s crew: ",name);
            for(int i=0; i<crew.size(); i++){
                        
                System.out.printf("%s", crew.get(i).getName());
                if(i<crew.size()-1)
                    System.out.print(", ");
            }
        System.out.println();
    }
}

}
