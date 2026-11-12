import java.util.ArrayList;

public class Spaceship {

    Spaceship(String name){
        System.out.println("\n[Spaceship] Building %s... ".formatted(name));
        this.name = name;
        lifeSupport = new LifeSupport();
        crew = new ArrayList<>();
    }
    public void boardCrew(Astronaut astronaut){
        if (astronaut == null){
            System.out.println("%s: no astronaut to board".formatted(name));
        }else if(crew.size() < 3){
            crew.add(astronaut);
            System.out.println("Boarded %s on %s (seat %d of 3)".formatted(astronaut.getName(), name, crew.size()));
        }else{
            System.out.println("%s is full: %s stays behind".formatted(name, astronaut.getName()));
        }

    }
    public void printManifest(){
        System.out.print(name + " crew: ");
        if(crew.isEmpty()){
            System.out.println("None");
        }else {
            for (int i = 0; i < crew.size(); i++) {
                System.out.print("%s, ".formatted(crew.get(i).getName()));
            }
        }
    }

    public String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;


}
