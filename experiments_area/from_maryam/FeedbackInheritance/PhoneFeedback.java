//Feedback>>>> parent class
//PhoneFeedback>>> child class
public class PhoneFeedback extends Feedback {

    // use private variables to store phone feedback information
    private  String phoneNumber;
    private  int callMinutes;

    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinutes) {


        // use super to create feedback information
        super(id, customerName, message, rating);

        this.phoneNumber = phoneNumber;
        this.callMinutes = callMinutes;

    }

    // use get to return the phone number
public String getPhoneNumber(){

    return this.phoneNumber;
}

    // use get to return the call minutes
public int getCallMinutes(){

    return this.callMinutes;
}
public String getSummary() {
    return "[Phone] " + getCustomerName() + " " + getPhoneNumber() + ", " + getCallMinutes() + " min: " + getMessage() + " (" + getRating() + "/5)";
}
}