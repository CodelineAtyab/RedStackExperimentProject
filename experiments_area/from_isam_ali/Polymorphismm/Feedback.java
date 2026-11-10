public abstract class Feedback {

    private int id;
    private String customerName;
    private int rating;
    private String message;

    public Feedback(int id, String customerName, String message, int rating) {
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
        if (message == null || message.isEmpty()) {
            System.out.println("Message cannot be empty");
        } else {
            this.message = message;
        }
    }

    public String toString() {
        return "#" + id + " " + getSummary();

    }


}