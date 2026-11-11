import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<PaymentMethod> methods = new ArrayList<>();
        methods.add(new CardPayment());
        methods.add(new BankTransferPayment());
        methods.add(new CashOnDeliveryPayment());
        methods.add(new WalletPayment());

        Checkout checkout = new Checkout();
        double amount = 25.0;
        for(PaymentMethod method : methods){
            checkout.checkout(method, amount);
        }
    }
}