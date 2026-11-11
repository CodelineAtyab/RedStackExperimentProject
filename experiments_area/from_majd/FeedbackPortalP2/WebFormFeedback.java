public class WebFormFeedback extends Feedback {

    public WebFormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);

    }

@Override 
    public String getSummary() {

        return "[Web] "+super.getCustomerName()+": "+super.getMessage()+"("+super.getRating()+"/5)";
    }


}
