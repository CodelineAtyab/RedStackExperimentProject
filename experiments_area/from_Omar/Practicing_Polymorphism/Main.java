public class Main {
    public static void main(String[] args) {
        //Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        //f.setRating(9);
        //f.setMessage("");
        //System.out.println(f.getCustomername() + " | " + f.getMessage() + " | " + f.getRating());
        //System.out.println(f.getSummary());
        FeedbackPortal portal = new FeedbackPortal();
        WebFormFeedback f = new WebFormFeedback(102, "Omar", "Encapsulation practice went smoothly!", 5);
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        portal.addFeedback(f);
        portal.addFeedback(e);
        portal.addFeedback(p);

        portal.printReport();
        System.out.printf("Average Rating: %.1f\n", portal.getAverageRating());

        /*
         * POLYMORPHISM EXPLANATION:
         * Runtime polymorphism occurs when portal.printReport() iterates over the
         * ArrayList<Feedback> and calls System.out.println(feedback). Even though the
         * collection only references elements as abstract 'Feedback' types, Java dynamically
         * resolves and invokes the specific overridden toString() and getSummary() implementations
         * belonging to WebFormFeedback, EmailFeedback, or PhoneFeedback at runtime.
         */
    }
}