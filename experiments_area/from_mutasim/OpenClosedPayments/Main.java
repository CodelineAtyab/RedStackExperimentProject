import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PaymentMethod> paymentOptions = new ArrayList<>();

        paymentOptions.add(new CardPayment());
        paymentOptions.add(new WalletPayment());
        paymentOptions.add(new BankTransferPayment());

        /* A new payment type can be added without changing Checkout
         because Checkout works with the abstract PaymentMethod class.*/
        paymentOptions.add(new CashOnDeliveryPayment());
        Checkout shopCheckout = new Checkout();

        double totalAmount = 25.0;

        for (PaymentMethod payment : paymentOptions) {
            shopCheckout.checkout(payment, totalAmount);
        }
    }
}