public class WebFormFeedback extends Feedback{

    //Feedback>>>> parent class
    //WebFormFeedback>>> child class
    // here to pass feedback details to the parent class
    public WebFormFeedback( int id , String customerName, String message, int rating){

        super(id, customerName, message, rating);
    }


    @Override
    // Here to implement the abstract method
    public String getSummary() {
        return "[Web] " + getCustomerName() + ": " + getMessage() + " (" + getRating() + "/5)";
    }
}
