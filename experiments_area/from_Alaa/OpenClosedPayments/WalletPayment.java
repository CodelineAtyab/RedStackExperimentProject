public class WalletPayment extends PaymentMethod {
    @Override
    public void Pay(double amount) {
        System.out.println("Paid OMR " + amount + " using Wallet.");
    }
}