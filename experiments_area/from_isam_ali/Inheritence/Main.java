public class Main {
    public static void main(String[] args) {

        FormFeedback f = new FormFeedback(1, "Essam", "Encapsulation practice went smoothly!", 5);
        System.out.println(f.getSummary());

        EmailFeedback e = new EmailFeedback(2, "Kumail", "Slow reply", 3, "kumail@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salam", "Helpful agent", 4, "99112233", 7);

        System.out.println(e.getSummary());
        System.out.println(p.getSummary());
        p.setRating(9);
    }
}