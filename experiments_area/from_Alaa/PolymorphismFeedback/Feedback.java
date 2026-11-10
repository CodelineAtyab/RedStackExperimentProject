
public abstract class Feedback {

    // private fields
    private int id;
    private String customerName;
    private int rating;
    private String message;

    // constructor
    public Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;

        // set default rating to 1, then validate using setters
        this.rating = 1;
        setMessage(message);
        setRating(rating);
    }

    // Getters
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

    // Setter for rating
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }
    }
    
    

    // Abstract method: subclasses must provide their own summary
    public abstract String getSummary();

    public String toString(){
        return getSummary();
    }
    
}
