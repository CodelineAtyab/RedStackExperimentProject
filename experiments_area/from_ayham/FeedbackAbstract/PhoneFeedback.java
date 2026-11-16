public class PhoneFeedback extends Feedback {
    private String phoneNumber;
    private int callMinutes;

    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinutes) {
        super(id, customerName, message, rating);
        this.phoneNumber = phoneNumber;
        this.callMinutes = callMinutes;
    }

    @Override
    public String getSummary() {
        return "Phone Feedback from " + getCustomerName() + ": " + getPhoneNumber() + " - " + getCallMinutes() + " min - " + getMessage() + " (Rating: " + getRating() + ")";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCallMinutes() {
        return callMinutes;
    }
    
}
