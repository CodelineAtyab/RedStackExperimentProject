public class Astronaut {

    private Astronaut(String name) {
        this.name = name;
    }

    public static Astronaut recruit(String name){
        if(recruitedCount < maximum){
            recruitedCount++;
            System.out.println("Recruited astronaut #%d: %s".formatted(recruitedCount, name));
            return new Astronaut(name);
        }else {
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

    private String name;
    static int maximum =4 ;
    static int recruitedCount =0;

}
