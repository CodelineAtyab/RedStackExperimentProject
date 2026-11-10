
public class Main {

    public static void main(String[] args) {

        Feedback f1 = new Feedback(1, "Aisha", "Great service", 5);

        f1.setRating(9);
        f1.setMessage("");

System.out.println(f1.getId() + " | " +
                   f1.getCustomerName() + " | " +
                   f1.getMessage() + " | " +
                   f1.getRating());

        Feedback f2 = new Feedback(2, "Noor", "Good product", 3);

        f2.setRating(4);
        f2.setMessage("Excellent product");

        System.out.println(f2.getId() + " | " +
                           f2.getCustomerName() + " | " +
                           f2.getMessage() + " | " +
                           f2.getRating());
    }
}
