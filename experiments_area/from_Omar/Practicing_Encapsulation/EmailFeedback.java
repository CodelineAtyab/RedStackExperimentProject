public class EmailFeedback extends Feedback{
    private String emailAddress;


    public EmailFeedback(int id, String customerName, String message, int rating, String emailAddress) {
        super(id, customerName, message, rating);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String getSummary() {
        return "[Email] " + super.getCustomername() + " (" + this.emailAddress + "): " + getMessage() + " (" + getRating() + "/5)";    }
}
