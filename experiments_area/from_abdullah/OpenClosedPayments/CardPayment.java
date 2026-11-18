import java.util.Locale;

public class CardPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println(String.format(
                Locale.US, "Paid OMR %.2f by card", amount));
    }
}