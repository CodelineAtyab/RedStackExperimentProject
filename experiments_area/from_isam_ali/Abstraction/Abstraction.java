public abstract class Abstraction {

    private int id;
    private String customerName;
    private int rating;
    private String message;

    public Abstraction(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;

        this.rating = 1;
        this.message = "";
        setRating(rating);
        setMessage(message);
    }

    public abstract String getSummary();

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message != null && message.length() > 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    public static void main(String[] args) {
        

        FormFeedback f = new FormFeedback(1, "Aisha", "Great service", 5);
        System.out.println(f.getSummary());
    }
}

class FormFeedback extends Abstraction {

    public FormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);
    }

    @Override
    public String getSummary() {
        return "[Web] " + getCustomerName() + ": " + getMessage()
                + " (" + getRating() + "/5)";
    }
}