public class CardPayment extends PaymentMethod {
    @Override 
    public void pay(double amount){
        System.out.printf("Paid OMR <%.2f> by Card",amount);
    }
    
}
