public class WalletPayment extends PaymentMethod {
    @Override 
    public void pay(double amount){
        System.out.printf("Paid OMR <%.2f> by Wallet",amount);
        
    }
}
