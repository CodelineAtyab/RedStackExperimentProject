public class WebFormFeedback extends FeedbackAbstract {
    public WebFormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);
    }

    @Override
    public String getSummary() {
        return "Web Form Feedback from " + getCustomerName() + ": " + getMessage() + " (Rating: " + getRating() + ")";
    }
    
}
