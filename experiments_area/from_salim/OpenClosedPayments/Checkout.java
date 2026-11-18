public class Checkout {
    public void checkout(PaymentMethod method, double amount) {
        System.out.printf("Checkout: OMR %.2f%n", amount);
        method.pay(amount);
        System.out.println("Thank you!");
    }
}