public class WebFormFeedback extends Feedback {
    public WebFormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);
    }
    public String getSummary() {
        return "[Web] " + getCustomerName() + ": " + getMessage() + " (" + getRating() + "/5)";
    }
}