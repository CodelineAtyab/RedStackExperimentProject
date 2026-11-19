package com.FeedbackPortalAbstraction;

public class WebFormFeedback extends Feedback {

    public WebFormFeedback(String customerName,int id, String message, int rating){
        super(customerName,id,message,rating);
    }

    public String getSummary(){
       return  "[Web] " + getCustomerName() + " : "  + getMessage() + " ("+getRating() +"/5)";
    }
}
