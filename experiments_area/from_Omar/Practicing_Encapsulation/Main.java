public class Main {
    public static void main(String[] args) {
        //Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        WebFormFeedback f = new WebFormFeedback(102, "Omar", "Encapsulation practice went smoothly!", 5);
        //f.setRating(9);
        //f.setMessage("");
        //System.out.println(f.getCustomername() + " | " + f.getMessage() + " | " + f.getRating());
        System.out.println(f.getSummary());
    }
}