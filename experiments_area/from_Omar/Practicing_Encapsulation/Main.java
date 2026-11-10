public class Main {
    public static void main(String[] args) {
        //Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        // f = new WebFormFeedback(102, "Omar", "Encapsulation practice went smoothly!", 5);
        //f.setRating(9);
        //f.setMessage("");
        //System.out.println(f.getCustomername() + " | " + f.getMessage() + " | " + f.getRating());
        //System.out.println(f.getSummary());
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());
        p.setRating(9);
    }
}