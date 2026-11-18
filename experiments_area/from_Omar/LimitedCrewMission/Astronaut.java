public class Astronaut {
    private String name;

    private static int max_astronauts = 4;
    private static int recruitedCount=0;

    private Astronaut(String name){
        this.name = name;
    }

    public static Astronaut recruit(String name) {
        if(recruitedCount < max_astronauts) {
            recruitedCount++;
            System.out.println("Recruited astronaut #" + recruitedCount + ": " + name);
            return new Astronaut(name);
        }
        else {
            System.out.println("Crew is full: cannot recruit " + name);
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public static int getRecruitedCount() {
        return recruitedCount;
    }
}