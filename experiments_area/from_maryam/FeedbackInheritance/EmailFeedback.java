//Feedback>>>> parent class
// EmailFeedback >>> child class
public class EmailFeedback extends Feedback {

    private String emailAddress;

    // here to create email feedback
    public EmailFeedback( int id , String customerName, String message, int rating, String emailAddress){

        // super used to call the parent class constructor and pass values from the child class to the parent class
        super(id, customerName, message, rating);

        this.emailAddress = emailAddress;
    }

    //here use get to return email address
    public String getEmailAddress(){

        return this.emailAddress = emailAddress;
    }
    public String getSummary() {
        return "[Email] " + getCustomerName() + " <" + getEmailAddress() + ">: " + getMessage() + " (" + getRating() + "/5)";
}
}
