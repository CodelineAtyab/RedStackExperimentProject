public class WalletPayment extends PaymentMethod {

    public void pay(double amount) {
        System.out.println("Paid OMR " + String.format("%.2f", amount) + " From wallet");
    }
}