import java.util.ArrayList;

public class Spaceship {
    String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut> crew;

    Spaceship(String name){
        System.out.printf("[Spaceship] Building %s\n",name);
        this.name = name;
        lifeSupport = new LifeSupport();
        crew = new ArrayList<>();
    }
    public void boardCrew(Astronaut astronaut){
        if (astronaut == null){
            System.out.printf("%s: no astronaut to board\n",name);
        }else if(crew.size() <3){
            crew.add(astronaut);
            System.out.printf("Boarded %s on %s (seat %d of 3)\n",
                    astronaut.getName(),name,crew.size());
        }else{
            System.out.printf("%s is full: %s stays behind\n", name, astronaut.getName());
        }

    }
    public void printManifest(){
        System.out.print(name + " crew: ");
        if(crew.isEmpty()){
            System.out.println("None");
        }else {
            for(Astronaut x : crew){
                System.out.printf("%s, ",x.getName());
            }
        }
    }
}
