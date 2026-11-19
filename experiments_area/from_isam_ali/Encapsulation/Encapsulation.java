public class Encapsulation {

    private int id;
    private String customerName;
    private String message;
    private int rating;

    public Encapsulation(int id, String customerName, int rating ,  String message) {
        this.id = id;
        this.customerName = customerName;

        rating = 1;
        setRating(rating);
        setMessage(message);
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMessage() {
        return this.message;

    }

    public void setMessage(String message) {
        if (message.isEmpty()) {
            System.out.println("No message");
        } else {
            this.message = message;
        }
    }

    public void setRating(int rating) {

        if (rating >= 1 || rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating value");
        }
    }

    public int getRating() {
        return this.rating;



    }

    public static void main(String[] args) {

        Encapsulation f1 = new Encapsulation(1,"Omar", 4, "Nice job");
        Encapsulation f2 = new Encapsulation(1, "Amina", 9, "Great service!");

        System.out.println("------ Inital state -----");
        print(f1);
        print(f2);

        System.out.println("--- Valid changes ---");
        f1.setRating(5);
        f1.setMessage("Excellent, thank you!");
        f2.setRating(3);
        f2.setMessage("Okay experience");
        print(f1);
        print(f2);


    }

    private static void print(Encapsulation f) {
        System.out.println("#" + f.getId() + " " + f.getCustomerName()
                + " | rating: " + f.getRating()
                + " | message: " + f.getMessage());
    }
}