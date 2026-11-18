public class Astronaut {

    private String name;

    private static int  MAX_ASTRONAUTS = 4;
    private static int recruitedCount = 0;

    private Astronaut(String name){
        this.name= name;
    }



    //her to recruits a new astronaut if there is space in the crew.
    public static Astronaut recruit(String name){


        // to checks if the crew has space for another astronaut.
        if( recruitedCount< MAX_ASTRONAUTS){
            recruitedCount++;
            System.out.println("Recruited astronaut #" + recruitedCount + ": " + name);

            return new Astronaut(name);


        }else {
            System.out.println("Crew is full: cannot recruit " + name);

            return null;
        }

    }

    public static int getRecruitedCount(){

        return recruitedCount;
    }

    public String getName(){

        return name;
    }



}
