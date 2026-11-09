public class PhoneFeedback extends Feedback{
    
    String phoneNumber;
    int callMinutes;
public PhoneFeedback(int getId, String customerName, String message, int rating, String phoneNumber, int callMinutes){
    super(getId,customerName,message, rating);

    this.phoneNumber=phoneNumber;
    this.callMinutes=callMinutes;

}




public int getCallMinutes(){
    return callMinutes;
}

public String getPhoneNumber(){
    return phoneNumber;
}



@Override 
public String getSummary() {

       return  "[Phone] "+super.getCustomerName()+"<"+phoneNumber+">"+", "+callMinutes+" min: "+super.getMessage()+"("+super.getRating()+"/5)";


};

}
