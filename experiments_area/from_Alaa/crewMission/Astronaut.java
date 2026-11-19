class Astronaut {

    //main thing is that only 4 objescts of Astronaut can be created and pass the name 
    //if more than 4 are created, the program will print an error message

    //first create a private static variable to keep track of the number of instances created
    private static int instanceCount = 0;
    private String name;
    private final int MAX_ASTRONAUTS = 4;



    //create a private constructor to prevent direct instantiation
    private Astronaut(String name) {
        this.name = name;
        
    }


    public static Astronaut recruit(String name){
        if (instanceCount < 4) {
            instanceCount++;
            System.out.println("Recruited astronaut # " + instanceCount + ": " + name);
            return new Astronaut(name);
        } else {
            System.out.println("Crew is full: cannot recruit " + name);
            return null;
        }
    }

    public int getRecruitCount() {
        return instanceCount;
    }

    public String getName() {
        return name;
    }

}