public class Main {

    public static void main(String[] args) {

        // here to create a WebFormFeedback object
        WebFormFeedback w = new WebFormFeedback(1, "Aisha", "Great service", 5);

        //and here to create an EmailFeedback object
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");

        // and create a PhoneFeedback object
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        //use it to print feedback summary
        System.out.println(w.getSummary());
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());

        // test the rating validation from Feedback
        p.setRating(9);
    }
}