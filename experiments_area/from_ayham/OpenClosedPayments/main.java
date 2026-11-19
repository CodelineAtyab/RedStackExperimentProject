import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(new WalletPayment());
        paymentMethods.add(new CardPayment());
        paymentMethods.add(new BankTransferPayment());
        paymentMethods.add(new CashOnDeliveryPayment());

        double amount = 25.0; // Example amount to pay
        for (PaymentMethod method : paymentMethods) {
            checkout.checkout(method, amount);
        }
    }
}
