import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        paymentMethods.add(new CardPayment());
        paymentMethods.add(new WalletPayment());
        paymentMethods.add(new BankTransferPayment());

        // New payment methods can be added without changing Checkout.
        paymentMethods.add(new CashOnDeliveryPayment());

        Checkout checkout = new Checkout();

        for (PaymentMethod method : paymentMethods) {
            checkout.checkout(method, 25.0);
        }
    }
}