public class main {
    public static void main(String[] args) {
        Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        f.setRating(9);
        f.setMessage("");
        System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());
    }
}