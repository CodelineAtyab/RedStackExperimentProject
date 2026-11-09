public class Feedback {
    private int id;
    private String customername;
    private String message;
    private int rating;


    public Feedback(int id, String customername, String message, int rating) {
        this.id = id;
        this.customername = customername;
        this.rating = 1;
        setRating(rating);
        setMessage(message);

    }

    public int getId() {
        return id;
    }

    public String getCustomername() {
        return customername;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if(message.length() != 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("invalid rating: " + rating);
        }
    }

    public static void main(String[] args) {
        Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        f.setRating(9);
        f.setMessage("");
        System.out.println(f.getCustomername() + " | " + f.getMessage() + " | " + f.getRating());
    }
}