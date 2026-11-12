public class Checkout {

    public void checkout(PaymentMethod method, double amount){
        System.out.println("Checkout: " + amount + " OMR");
        method.pay(amount);
        System.out.println("Thank you");
    }
}