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

        // Why could we add CashOnDeliveryPayment without changing Checkout?
        // Checkout only knows about the PaymentMethod parent type and calls pay().
        // CashOnDeliveryPayment extends PaymentMethod, so it fits that type, and
        // Java runs its own pay() at runtime. Adding a new class extends the
        // program, while Checkout stays closed to modification.
        //
        // Why ArrayList<PaymentMethod> and not ArrayList<CardPayment>?
        // A list of CardPayment could only hold card payments. Using the parent
        // type lets one list hold every kind of payment method.
    }
}
