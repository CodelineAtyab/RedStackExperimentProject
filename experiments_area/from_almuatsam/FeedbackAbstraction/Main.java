public class Main {

    public static void main(String[] args) {

        WebFormFeedback feedback = new WebFormFeedback(1, "Aisha", "Great service", 5);

        System.out.println(feedback.getSummary());

        // Feedback direct = new Feedback(2, "Omar", "Fast delivery", 4);
        // This cannot compile because Feedback is abstract. An abstract class
        // is incomplete (getSummary() has no body), so Java does not allow
        // creating objects from it directly. Only a concrete child class such
        // as WebFormFeedback, which implements getSummary(), can be instantiated.
    }
}
