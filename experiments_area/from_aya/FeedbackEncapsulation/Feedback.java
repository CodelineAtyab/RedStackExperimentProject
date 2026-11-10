package com.FeedbackEncapsulation;

public class Feedback {


    public Feedback(int id,String customerName,String message,int rating){
        this.id =id;
        this.customerName =customerName;
        this.rating = 1;
        setMessage(message);//check if it is empty
        setRating(rating);//check if the rating 1-5
    }

    //create getter for all 4
    //getter --> is public methods that allow other class to read
    //a privet fileds without accessung it directlt

    //id getter
    public int getId(){//public so the other class can access
        return id;
    }

    //customername getter
    public String getCustomerName() {
        return customerName;
    }

    //message getter
    public String getMessage() {
        return message;
    }

    //rating getter
    public int getRating() {
        return rating;
    }

    //setter -->is a public method theat allow other class to change a privet fiels
    public void setRating( int rating){
        if (rating >=1 && rating <=5){
            this.rating = rating;
        }else {
            System.out.println("Invalid rating: " + rating);
        }


    }

    public void setMessage(String message) {
        if (message.length() != 0) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }

    }
    private int id;
    private String customerName;
    private String message;
    private int rating;
}


