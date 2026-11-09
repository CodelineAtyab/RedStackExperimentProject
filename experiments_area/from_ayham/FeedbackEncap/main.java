public class main {
    public static void main(String[] args) {
        FeedbackEncap feedback1 = new FeedbackEncap(1, "John Doe", "Great service!", 5);
        System.out.println("Feedback ID: " + feedback1.getId());
        System.out.println("Customer Name: " + feedback1.getCustomerName());
        System.out.println("Message: " + feedback1.getMessage());
        System.out.println("Rating: " + feedback1.getRating());

        FeedbackEncap feedback2 = new FeedbackEncap(2, "Jane Smith", "", 6); // Invalid message and rating
        System.out.println("Feedback ID: " + feedback2.getId());
        System.out.println("Customer Name: " + feedback2.getCustomerName());
        System.out.println("Message: " + feedback2.getMessage());
        System.out.println("Rating: " + feedback2.getRating());
    }
}
