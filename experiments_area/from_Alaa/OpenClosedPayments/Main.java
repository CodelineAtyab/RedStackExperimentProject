import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        //adding the subclasses of PaymentMethod to the list
        paymentMethods.add(new CardPayment());
        paymentMethods.add(new WalletPayment());
        paymentMethods.add(new BankTransferPayment());

        //after checking 3 methods are working, now we can add another payment method
        paymentMethods.add(new CashOnDeliveryPayment());

        Checkout ch = new Checkout(); //new object of Checkout class

        //loop through the list and call the checkout method for each payment method
        for (PaymentMethod paymentMethod : paymentMethods) {
            ch.checkout(paymentMethod, 25.0); 
            /*Checkout can process any PaymentMethod subclass without changing its code.
            This is possible because of polymorphism and follows the Open/Closed Principle.*/
        }
    }
}