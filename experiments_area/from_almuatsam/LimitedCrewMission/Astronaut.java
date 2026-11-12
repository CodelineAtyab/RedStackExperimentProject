public class Astronaut {

    // Static: shared by the whole class, not owned by any single astronaut.
    public static final int MAX_ASTRONAUTS = 4;
    private static int recruitedCount = 0;

    // Instance field: each astronaut has their own name.
    private String name;

    private Astronaut(String name) {
        this.name = name;
    }

    public static Astronaut recruit(String name) {
        if (recruitedCount < MAX_ASTRONAUTS) {
            recruitedCount++;
            System.out.println("Recruited astronaut #" + recruitedCount + ": " + name);
            return new Astronaut(name);
        }
        System.out.println("Crew is full: cannot recruit " + name);
        return null;
    }

    public static int getRecruitedCount() {
        return recruitedCount;
    }

    public String getName() {
        return name;
    }

}
