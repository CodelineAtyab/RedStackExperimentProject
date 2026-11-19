public class Astronaut {

    private String name;
    static int MAX_ASTRONAUTS=4;
    static int recruitedCount=0;

    private Astronaut(String name){
        this.name = name;
    }

    static Astronaut recruit(String name){
        if(recruitedCount<MAX_ASTRONAUTS){
            recruitedCount++;
            System.out.println("Recruited astronaut #%d:%s".formatted(recruitedCount, name));
            return new Astronaut((name));
        } else{
            System.out.print("Crew is full: cannot recruit %s".formatted(name));
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
