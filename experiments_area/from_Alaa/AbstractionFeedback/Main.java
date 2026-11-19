public class Main {

    public static void main(String[] args) {
        WebFormFeedback feedback = new WebFormFeedback(1, "Aisha", "Great service", 5); //creating an object of the child class
        System.out.println(feedback.getSummary());

        // This will not compile because Feedback is abstract and we cant access it directly
        //Feedback feedback2 = new Feedback(2, "Ali", "Good", 4);

    }
}