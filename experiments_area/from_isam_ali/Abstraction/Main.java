public class Main {

    public static void main(String[] args) {

        Feedback feedback = new WebFormFeedback(1, "Aisha", "Great service", 5);
        System.out.println(feedback.getSummary());
    }
}
