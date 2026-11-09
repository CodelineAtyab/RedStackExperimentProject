public class Feedback {
    private int id;
    private String customerName;
    private String message;
    private int rating;

    public Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.rating = 1;

        setMessage(message);
        setRating(rating);
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMessage() {
        return message;
    }

    public int getRating() {
        return rating;
    }

    public void setMessage(String message) {
        if(message.length() == 0){
            System.out.println("Message cannot be empty");
        }
        else{
            this.message = message;
        }
    }

    public void setRating(int rating) {
        if(rating >= 1 && rating <=5){
            this.rating = rating;
        }
        else{
            System.out.println("Invalid rating: " + rating);
        }
    }
}