import java.util.Locale;

public class CashOnDeliveryPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println(String.format(
                Locale.US,
                "Pay OMR %.2f in cash when the order arrives",
                amount));
    }
}