public class PhoneFeedback extends Feedback{

    private String phoneNumber;
    private int callMinute;

    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinute) {
        super(id,customerName,message,rating);
        this.phoneNumber = phoneNumber;
        this.callMinute = callMinute;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCallMinute() {
        return callMinute;
    }

    @Override
    public String getSummary(){
        return "[Phone] " + getCustemerName() + getPhoneNumber() + ", " + getCallMinute() + " min: " + getMessage() + " (" + getRating() + "/)";
    }
}