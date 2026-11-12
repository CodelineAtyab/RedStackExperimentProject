import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(new CardPayment());
        paymentMethods.add(new WalletPayment());
        paymentMethods.add(new BankTransferPayment());

        // Task 5: Adding the fourth class without modifying Checkout or other classes
        paymentMethods.add(new CashOnDeliveryPayment());

        Checkout checkoutSystem = new Checkout();

        for (PaymentMethod method : paymentMethods) {
            checkoutSystem.checkout(method, 25.0);
            System.out.println(); // Optional spacing between items
        }

        /*
         * Why adding CashOnDeliveryPayment did not require editing Checkout:
         * Checkout only interacts with the abstract PaymentMethod type via polymorphism.
         * Because Checkout invokes the abstract .pay() contract rather than checking
         * concrete types using conditional statements, any newly introduced subclass
         * fits seamlessly into the existing pipeline without breaking encapsulation.
         */
    }
}