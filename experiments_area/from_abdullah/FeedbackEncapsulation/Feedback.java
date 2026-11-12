public class Feedback {

    private int id;
    private String customerName;
    private String message;
    private int rating;

    public Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.message = "";
        this.rating = 1; // Default fallback

        changeMessage(message);
        changeRating(rating);
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

    public void changeMessage(String newMessage) {
        setMessage(newMessage);
    }

    public void changeRating(int newRating) {
        setRating(newRating);
    }

    public void setMessage(String newMessage) {
        if (newMessage != null && !newMessage.trim().isEmpty()) {
            this.message = newMessage;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    public void setRating(int newRating) {
        if (newRating < 1 || newRating > 5) {
            System.out.println("Invalid rating: " + newRating);
            return;
        }
        this.rating = newRating;
    }
}
