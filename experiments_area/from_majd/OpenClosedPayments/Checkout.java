public class Checkout {

    public Checkout(PaymentMethod method, double amount){
        System.out.printf("Checkout: OMR %.2f", amount);
        method.pay(amount);

        System.out.println("Thank you!");
    }
}