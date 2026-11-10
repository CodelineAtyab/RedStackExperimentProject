public class EmailFeedback extends Feedback{
    private String email;


    public EmailFeedback(int id, String customerName, String message, int rating, String email) {
        super(id, customerName, message, rating);
        this.email = email;
    }

    public String getEmailAddress() {
        return email;
    }

    @Override
    public String getSummary() {
        return "[Email] " + super.getCustomerName() + " (" + this.email + "): " + getMessage() + " (" + getRating() + "/5)";    }
}