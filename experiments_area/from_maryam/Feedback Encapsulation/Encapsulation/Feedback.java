
public class Feedback {

    // Private variables to store feedback information
    private int id;
    private String customerName;
    private String message;
    private int rating;

    // Constructor to create a feedback object
    public Feedback(int id, String customerName, String message, int rating) {

        // Store the id and customer name
        this.id = id;
        this.customerName = customerName;

        // Use the setter to validate the message
        this.setMessage(message);

        // Set the default rating to 1
        this.rating = 1;

        // Use the setter to validate the rating
        this.setRating(rating);
    }

    // Getter to return the id
    public int getId() {
        return this.id;
    }

    // Getter to return the customer name
    public String getCustomerName() {
        return this.customerName;
    }

    // Getter to return the message
    public String getMessage() {
        return this.message;
    }

    // Getter to return the rating
    public int getRating() {
        return this.rating;
    }

    // Setter to update the rating if it is between 1 and 5
    public void setRating(int rating) {

        // Check if the rating is valid
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }

    }

    // Setter to update the message
    public void setMessage(String message) {

        // Check if the message is not empty
        if (message.length() > 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }

    }
}

