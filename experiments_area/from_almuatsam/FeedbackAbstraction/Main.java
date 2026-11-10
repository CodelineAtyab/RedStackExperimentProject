public class Main {

    public static void main(String[] args) {

        WebFormFeedback w = new WebFormFeedback(1, "Aisha", "Great service", 5);
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        System.out.println(w.getSummary());
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());

        // setRating() is declared in Feedback, not in PhoneFeedback.
        // 9 is outside 1 to 5, so the inherited validation rejects it.
        p.setRating(9);

        // Feedback direct = new Feedback(4, "Test", "Direct object", 5);
        // This cannot compile because Feedback is abstract. An abstract class
        // is incomplete (getSummary() has no body), so Java does not allow
        // creating objects from it directly. Only a concrete child class such
        // as WebFormFeedback, which implements getSummary(), can be instantiated.
    }
}
