import java.util.ArrayList;

public class Spaceship {

    // her to stores the spaceship name,life support system  and crew.
    private String name;
    private LifeSupport lifeSupport;
    private ArrayList<Astronaut>crew;

    private static final int MAX_SEATS=3;

    //her to creates a spaceship with its own life support system and an empty crew.
    public Spaceship(String name){

        this.name= name;

        System.out.println("[Spaceship] Building " + name + "...");

        lifeSupport= new LifeSupport();

        crew= new ArrayList<>();
    }
    // add astronaut to the spaceship if there is an available seat
    public void boardCrew(Astronaut astronaut){

        if (astronaut==null){
            System.out.println(name + ": no astronaut to board");
            // her to checks if there is an available seat.
        }else if(crew.size()< MAX_SEATS){

            crew.add(astronaut);

            System.out.println("Boarded " + astronaut.getName() + " on " + name + " (seat " + crew.size() + " of 3)");


        }else {
            System.out.println(name + " is full: " + astronaut.getName() + " stays behind");
        }
    }

    //this to prints the list of astronauts on the spaceship
    public void printManifest(){
        System.out.print(name + " crew: ");

        if (crew.isEmpty()){

            System.out.println("none");

        }else{

            for(int i=0; i< crew.size(); i++){

                if (i < crew.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();


            }
        }
    }

