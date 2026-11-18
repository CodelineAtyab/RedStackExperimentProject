public class Astronaut {
    private String name;
    static int MAX_ASTRONAUTS = 4;
    static int recruitedCount = 0;

    private Astronaut(String name) {
        this.name = name;
    }
    public static Astronaut recruit(String name){
        if(recruitedCount < MAX_ASTRONAUTS)
        {
            recruitedCount++;
            System.out.printf("Recruited astronaut #%s: %s\n",getRecruitedCount(),name);
            return new Astronaut(name);
        }else {
            System.out.printf("Crew is full: cannot recruit %s\n",name);
            return null;
        }
    }
    public static int getRecruitedCount() {
        return recruitedCount;
    }

    public String getName() {
        return name;
    }
}