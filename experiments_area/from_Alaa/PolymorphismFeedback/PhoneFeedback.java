public class PhoneFeedback extends Feedback {

    // Extra fields
    private String phoneNumber;
    private int callMinutes;

    // Constructor
    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinutes) {
        super(id, customerName, message, rating);  //passed to the parent 

        this.phoneNumber = phoneNumber;
        this.callMinutes = callMinutes;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for call minutes
    public int getCallMinutes() {
        return callMinutes;
    }

    // Implement abstract method
    @Override
    public String getSummary() {
        return "[Phone] " + getCustomerName() + " " + getPhoneNumber() + ", " + getCallMinutes() + " min: " + getMessage() + " (" + getRating() + "/5)";
    }
}