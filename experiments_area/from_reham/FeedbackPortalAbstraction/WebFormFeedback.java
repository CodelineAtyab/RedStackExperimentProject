public class WebFormFeedback extends Feedback {
    //Constructor 
    public WebFormFeedback(int id  , String customerName, String message , int rating){
        super(id, customerName, message, rating);
    }
    
    @Override

    public String getSummary(){
      return "[web] "+getCustomerName()+": "+getMessage()+" ("+getRating()+"/5)";  
    }


    
}
