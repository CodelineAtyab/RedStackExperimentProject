public class InheritanceMain {
    public static void main(String[] args) {

        WebFormFeedback w = new WebFormFeedback(1, "Mohammed", "Great service", 5);
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        System.out.println(w.getSummary());
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());

        p.setRating(9);
    }
}