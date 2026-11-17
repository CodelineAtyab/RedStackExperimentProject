
public class Main {

    public static void main(String[] args) {

        // Recruit astronauts
        Astronaut astronaut1 = Astronaut.recruit("John");
        Astronaut astronaut2 = Astronaut.recruit("Alice");
        Astronaut astronaut3 = Astronaut.recruit("Bob");
        Astronaut astronaut4 = Astronaut.recruit("Eve");
        Astronaut astronaut5 = Astronaut.recruit("Charlie");

       //create a spaceship
        Spaceship spaceship = new Spaceship("falcone");

        // Board astronauts onto the spaceship
        spaceship.boardCrew(astronaut1);
        spaceship.boardCrew(astronaut2);
        spaceship.boardCrew(astronaut3);
        spaceship.boardCrew(astronaut4); // This astronaut should not be boarded

        // Print the crew manifest
        spaceship.printManifest();
    }
}
