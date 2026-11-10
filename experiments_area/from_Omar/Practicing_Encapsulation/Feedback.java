public abstract class Feedback {
    private int id;
    private String customerName;
    private String message;
    private int rating;


    public Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.rating = 1;
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
        return message;
    }

    public void setMessage(String message) {
        if(message.length() != 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("invalid rating: " + rating);
        }
    }

    public abstract String getSummary();

    @Override
    public String toString() {
        return "#"+id+" "+ getSummary();
    }
}