public class Feedback {
    private int id;
    private String customerName;
    private String message;
    private int rating;

    public Feedback(int Id, String CustomerName ,String Message,int Rating){
        this.id=Id;
        this.customerName=CustomerName;
        this.message=Message;
        this.rating=Rating;
    }

    //Getters : returns the value of the variable 
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

    //setter: takes the parameter an assign it to the variable.
    public  void setMessage(String Message){
        if (Message.isEmpty()){
            System.out.println("Message cannot be empty. ");
        }
        else{
        this.message=Message;
        }
    }
    public void setRating(int Rating){
        if (Rating>=1 && Rating<=5){
        this.rating=Rating;
        }else{
            System.out.println("Invalid rating "+Rating);
        }
    }






}
