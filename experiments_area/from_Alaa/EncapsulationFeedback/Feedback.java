
// this file contains the class responsible for storing and protecting feedback information.

public class Feedback {

    // private fields meaning they are only accessible inside the class
    private int id;
    private String customerName;
    private String message;
    private int rating;

    // feedback object (the constructor)
    public Feedback(int id, String customerName, String message, int rating) {

        // assign incoming data to the private fields
        this.id = id;
        this.customerName = customerName;

        // set default rating to 1, then validate incoming values using setters
        this.rating = 1;
        setMessage(message);
        setRating(rating);
    }

    // Getters for reading private fields
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMessage() {
        return message;
    }

    public int getRating() {
        return rating;
    }

    // Setter for message
    public void setMessage(String message) {
        if (message.length() > 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    // Setter for rating (with safety validation)
    public void setRating(int rating) {
        // Enforce a rule that the rating must be between 1 and 5 stars
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }
    }
}
