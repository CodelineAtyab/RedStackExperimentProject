import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PaymentMethod> methods = new ArrayList<>();

        methods.add(new CardPayment());
        methods.add(new WalletPayment());
        methods.add(new BankTransferPayment());

        methods.add(new CashOnDeliveryPayment());

        Checkout checkout = new Checkout();

        for (PaymentMethod method : methods) {
            checkout.checkout(method, 25.0);
        }
    }
}
