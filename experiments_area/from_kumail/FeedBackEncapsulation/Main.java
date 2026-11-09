
public class Main {

    public static void main(String[] args) {

        Feedback f1 = new Feedback(1, "Aisha", "Great service", 5);

        Feedback f2 = new Feedback(2, "Ahmed", "Good coffee", 4);

        f1.setRating(9);
        f1.setMessage("");

        f2.setRating(3);
        f2.setMessage("Excellent coffee");

        System.out.println("\nFeedback 1:");
        System.out.println(f1.getCustomerName() + " | " + f1.getMessage() + " | " + f1.getRating());

        System.out.println("\nFeedback 2:");
        System.out.println(f2.getCustomerName() + " | " + f2.getMessage() + " | " + f2.getRating());
    }
}