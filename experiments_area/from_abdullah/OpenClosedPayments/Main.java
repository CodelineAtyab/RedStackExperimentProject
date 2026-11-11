import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PaymentMethod> methods = new ArrayList<>();

        methods.add(new CardPayment());
        methods.add(new WalletPayment());
        methods.add(new BankTransferPayment());
        methods.add(new CashOnDeliveryPayment());

        // Checkout uses PaymentMethod, so a new payment class needs no changes there.
        Checkout checkout = new Checkout();

        for (int i = 0; i < methods.size(); i++) {
            checkout.checkout(methods.get(i), 25.0);
        }
    }
}