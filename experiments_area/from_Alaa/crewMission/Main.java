public class Main{

    public static void main (String[] args) {
        Astronaut astronaut1 = Astronaut.recruit("John");
        Astronaut astronaut2 = Astronaut.recruit("Alice");
        Astronaut astronaut3 = Astronaut.recruit("Bob");
        Astronaut astronaut4 = Astronaut.recruit("Eve");
        //Astronaut astronaut5 = Astronaut.recruit("Charlie"); // This should print an error message

        System.out.println("Total astronauts recruited: " + astronaut1.getRecruitCount());
    }
}