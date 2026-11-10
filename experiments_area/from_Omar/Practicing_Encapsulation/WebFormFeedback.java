public class WebFormFeedback extends Feedback {

    public WebFormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);
    }

    @Override
    public String getSummary() {
        return "#" + getId() + " [Web] " + getCustomername() + ": " + getMessage() + " (" + getRating() + "/5)";
    }
}
