import java.util.Locale;

public class BankTransferPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println(String.format(
                Locale.US, "Paid OMR %.2f by bank transfer", amount));
    }
}