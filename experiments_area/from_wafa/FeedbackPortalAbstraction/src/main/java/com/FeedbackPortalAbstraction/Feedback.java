package com.FeedbackPortalAbstraction;

public  abstract class Feedback {

    public Feedback(String customerName, int id, String message, int rating) {
        this.customerName = customerName;
        this.id = id;
        this.message = message;
        this.rating = rating;
    }

    public int getId(){

        return id;
    }

    public String getCustomerName(){

        return customerName;
    }

    public String getMessage(){
        return message;
    }

    public int getRating(){

        return rating;
    }

    public void setMessage(String message){

        if (message.isEmpty()){
            System.out.println("Message cannot be empty");
        }else {
            this.message=message;
        }
    }

    public void setRating(int rating){

        if(rating >=1 && rating <= 5){
          this.rating=rating;
        }else {
            System.out.println("Invalid rating: " + rating);
        }
    }

    public abstract String getSummary();

    private int id;
    private String customerName;
    private String message;
    private int rating;

}
