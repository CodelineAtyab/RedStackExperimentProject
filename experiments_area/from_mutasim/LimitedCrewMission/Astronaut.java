public class Astronaut {

    private String name;
    private static final int MAX_ASTRONAUTS = 4;
    private static int recruitedCount = 0;

    private Astronaut(String astronautName) {
        this.name = astronautName;
    }

    public static Astronaut recruit(String candidateName) {
        if (recruitedCount < MAX_ASTRONAUTS) {
            recruitedCount++;
            System.out.println("Recruited astronaut #" + recruitedCount + ": " + candidateName);
            return new Astronaut(candidateName);
        } else {
            System.out.println("Crew is full: cannot recruit " + candidateName);
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