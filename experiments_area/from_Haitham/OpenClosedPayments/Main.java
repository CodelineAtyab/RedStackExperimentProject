import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PaymentMethod> paying = new ArrayList<>();
        paying.add(new BankTransferPayment());
        paying.add(new CardPayment());
        paying.add(new WalletPayment());
        double amount = 25.0;
        Checkout checkout = new Checkout();
        for (PaymentMethod pay : paying){
            checkout.checkout(pay,amount);
        }
    }
}
