package OpenClosedPayments;

public class Checkout {

    public void checkout(PaymentMethod method, double amount) {

        System.out.println("Checkout: OMR " + String.format("%.2f", amount));

        method.pay(amount);

        System.out.println("Thank you!");
    }
}
