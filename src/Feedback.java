public class Feedback {
    //private variables
    private int id;
    private String CustomerName;
    private String message;
    private int rating;

    //constructor
    public Feedback(int id ,String CustomerName,String message,int rating)
    {
        this.id = id;
        this.CustomerName = CustomerName;
        this.rating = 1;

        setMessage(message);
        setRating(rating);
    }

    //getter
    public int getId() {
        return id;
    }
    public String getCustomerName(){
        return CustomerName;
    }
    //getter
    public String getMessage() {
        return message;
    }
        //getter
        public int getRating() {
            return rating;
        }
            // Setter for message
            public void setMessage(String message) {
                if (message .length()!=0) {
                    this.message = message;
                } else {
                    System.out.println("Message cannot be empty.");
                }
            }

            // Setter for rating
            public void setRating(int rating) {
                if (rating >= 1 && rating <= 5) {
                    this.rating = rating;
                } else {
                    System.out.println("Invalid rating:"+rating);
                }
            }
        }
