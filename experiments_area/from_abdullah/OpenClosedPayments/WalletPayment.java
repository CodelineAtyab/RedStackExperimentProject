import java.util.Locale;

public class WalletPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println(String.format(
                Locale.US, "Paid OMR %.2f from wallet", amount));
    }
}