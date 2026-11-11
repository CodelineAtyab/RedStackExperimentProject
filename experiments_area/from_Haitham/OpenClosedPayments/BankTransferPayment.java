public class BankTransferPayment extends PaymentMethod {
    @Override 
    public void pay(double amount){
        System.out.println("Paid OMR <"+amount +"> by bank transfer");
        
    }
    
}
