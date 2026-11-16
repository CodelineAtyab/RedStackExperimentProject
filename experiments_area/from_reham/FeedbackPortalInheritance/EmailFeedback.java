public class EmailFeedback extends Feedback{
    private String emailAddress;
    public EmailFeedback(int id,String customerName, String message, int rating , String emailAddress){
        super(id, customerName, message, rating);
        this.emailAddress=emailAddress;
    }
    //getter
    public String getEmailAddress(){
        return emailAddress;
    }

    @Override 
    public String getSummary(){
        return "[Email] "+getCustomerName()+" <"+getEmailAddress()+">: "+getMessage() +" ("+getRating()+"/5)";
    }

}
