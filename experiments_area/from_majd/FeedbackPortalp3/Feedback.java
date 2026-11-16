public abstract class Feedback {
    
private int id;
private String customerName;
private String message;
private int rating;


public int getId(){

return id;

}



public abstract String getSummary();


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

    if(message.isEmpty())
        System.out.println("Message cannot be empty");
    else
this.message=message;

}


public void setRating(int rating){

    if(rating>5 || rating<1)
        System.out.println("Invalid rating: "+rating);
this.rating=rating;

}

public Feedback(int id, String customerName, String message, int rating){

this.id=id;
this.customerName=customerName;

setMessage(message);
setRating(rating);


}



}