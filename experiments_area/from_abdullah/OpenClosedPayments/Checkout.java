import java.util.Locale;

public class Checkout {

    public void checkout(PaymentMethod method, double amount) {
        System.out.println(String.format(
                Locale.US, "Checkout: OMR %.2f", amount));

        method.pay(amount);

        System.out.println("Thank you!");
    }
}