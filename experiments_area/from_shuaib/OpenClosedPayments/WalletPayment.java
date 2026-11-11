public class WalletPayment extends PaymentMethod{

    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " OMR from Wallet");
    }
}