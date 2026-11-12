public class Astronaut {
    private String name;
    private static int MAX_ASTRONAUTS = 4;
    private static int RecruitedCount = 0;

    private Astronaut(String name) {
        this.name = name;
    }

    public static Astronaut recruit(String name) {
        if (RecruitedCount < MAX_ASTRONAUTS) {
            RecruitedCount++;
            System.out.println("Astronaut " + name + " recruited. Total astronauts: " + RecruitedCount);
            return new Astronaut(name);
        } else {
            System.out.println("Crew is full: cannot recruit " + name);
            return null;
        }
    }

    public static int getRecruitedCount() {
        return RecruitedCount;
    }

    public String getName() {
        return name;
    }
}