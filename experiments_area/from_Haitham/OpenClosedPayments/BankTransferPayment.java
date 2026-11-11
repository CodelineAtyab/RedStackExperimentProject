public class BankTransferPayment extends PaymentMethod {
    @Override 
    public void pay(double amount){
        System.out.printf("Paid OMR <%.2f> by bank transfer",amount);
        
    }
    
}
