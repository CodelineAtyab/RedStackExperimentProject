public class Main {
    public static void main(String[] args) {

        WebFormFeedback feedback =
                new WebFormFeedback(1, "Noor", "Great service", 5);

        System.out.println(feedback.getSummary());
// Can't create an object from an abstract class
// Feedback f = new Feedback(2, "Ali", "Good", 4);
    }
}