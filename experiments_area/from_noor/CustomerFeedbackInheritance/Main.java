public class Main {
    public static void main(String[] args) {

        WebFormFeedback web = new WebFormFeedback(
                1, "Noor", "Great service", 5);

        EmailFeedback email = new EmailFeedback(
                2, "Omar", "Slow reply", 3, "omar@mail.com");

        PhoneFeedback phone = new PhoneFeedback(
                3, "Salma", "Helpful agent", 4, "99112233", 7);

        System.out.println(web.getSummary());
        System.out.println(email.getSummary());
        System.out.println(phone.getSummary());

        phone.setRating(9);
    }
}