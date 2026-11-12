import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // her to creates a list of payment methods.
        ArrayList<PaymentMethod> payments= new ArrayList<>();

        // it has diff payment in a list
        payments.add(new CardPayment());
        payments.add(new WalletPayment());
        payments.add(new BankTransferPayment());
        payments.add(new CashOnDeliveryPayment());

        // create a checkout obj
        Checkout checkout= new Checkout();

        // her to process each payment method 
        for(PaymentMethod method : payments){

            checkout.checkout(method, 25.0);
        }

    }
    }