import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<PaymentMethod> methods = new ArrayList<>();

        methods.add(new CardPayment());
        methods.add(new WalletPayment());
        methods.add(new BankTransferPayment());
        methods.add(new CashOnDeliveryPayment());

        double amount = 25.0;

        for (int i = 0; i < methods.size(); i++) {
            PaymentMethod method = methods.get(i);
            Checkout.checkout(method, amount);
        }
    }
}