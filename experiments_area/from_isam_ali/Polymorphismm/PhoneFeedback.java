public class PhoneFeedback extends Feedback {
    private String phonenumber;
    private int callMin;

    public PhoneFeedback(int id, String customerName, String message, int rating, String phonenumber, int callMin) {
        super(id, customerName, message, rating);
        this.phonenumber = phonenumber;
        this.callMin = callMin;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public int getCallMin() {
        return callMin;
    }

    @Override
    public String getSummary() {
        return " [Phone] " + super.getCustomerName() + " " + this.phonenumber + ", " + this.callMin + " min: " + getMessage() + " (" + getRating() + "/5)";
    }
}