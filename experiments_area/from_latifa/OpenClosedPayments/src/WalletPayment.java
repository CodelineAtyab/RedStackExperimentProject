public class WalletPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid OMR " + String.format("%.2f", amount) + " from wallet");
    }
}