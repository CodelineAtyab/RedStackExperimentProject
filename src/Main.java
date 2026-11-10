
public class Main {

    public static void main(String[] args) {

        // Create first feedback object
        Feedback f1 = new Feedback(1, "Aisha", "Great service", 5);

        // Create second feedback object
        Feedback f2 = new Feedback(2, "Ahmed", "Very helpful staff", 4);

        // Try valid and invalid changes
        f1.setRating(3);
        f1.setRating(9);
        f1.setMessage("");

        f2.setRating(5);
        f2.setMessage("Excellent experience");

        // Print first feedback
        System.out.println("\nFirst Feedback:");
        System.out.println(
                f1.getId() + " | " +
                        f1.getCustomerName() + " | " +
                        f1.getMessage() + " | " +
                        f1.getRating()
        );

        // Print second feedback
        System.out.println("\nSecond Feedback:");
        System.out.println(
                f2.getId() + " | " +
                        f2.getCustomerName() + " | " +
                        f2.getMessage() + " | " +
                        f2.getRating()
        );
    }
}
