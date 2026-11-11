public class WebFormFeedback extends Feedback { // extend means it inherits the fields and methods from Feedback

    public WebFormFeedback(int id, String customerName, String message, int rating) {
    super(id, customerName, message, rating); //a constructor that is passed to the constructor in the parent
    }   


    // Implement the abstract method from the parent class
    @Override // meaning this method we are imlementing already exists in the parent
    public String getSummary() {
        return "[Web] " + getCustomerName() + ": " + getMessage() + " (" + getRating() + "/5)";
    }
}

