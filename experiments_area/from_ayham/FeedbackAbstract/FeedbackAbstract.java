public abstract class FeedbackAbstract {
    private int id;
    private String customerName;
    private String message;
    private int rating;


    public FeedbackAbstract(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.message = ""; 
        setMessage(message);
        this.rating = 1;
        setRating(rating);
    }

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

    public void setMessage(String message) {
        if (message != null && !message.isEmpty()) {
            this.message = message;
        } else {
            System.out.println("Invalid message. Please provide a non-empty message.");
        }
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating + ". Please provide a rating between 1 and 5.");
        } 
    }

    public abstract String getSummary();
}
