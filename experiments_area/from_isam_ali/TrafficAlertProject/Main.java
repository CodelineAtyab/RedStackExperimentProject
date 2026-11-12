public class Main {

    public static void main(String[] args) {
        Astronaut a1 = Astronaut.recruit("Xehanort");
        Astronaut a2 = Astronaut.recruit("Luxu");
        Astronaut a3 = Astronaut.recruit("Siax");
        Astronaut a4 = Astronaut.recruit("Luxord");
        Astronaut a5 = Astronaut.recruit("Roxas");

        Spaceship falcon = new Spaceship("Falcon");
        falcon.boardCrew(a1);
        falcon.boardCrew(a2);
        falcon.boardCrew(a3);
        falcon.boardCrew(a4);
        falcon.boardCrew(a5);
        falcon.printManifest();
        falcon = null;

        Spaceship comet = new Spaceship("Comet");
        comet.boardCrew(a3);
        comet.boardCrew(a4);
        comet.printManifest();

        System.out.println("Siax is still here: " + a3.getName());
        System.out.println("Recruited so far: " + Astronaut.getRecruitedCount());

    }







}