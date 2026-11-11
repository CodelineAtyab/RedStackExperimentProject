public class Checkout {
    public void checkout(PaymentMethod method, double amount){
        System.out.println("Checkout: OMR <"+amount+">");
        method.pay(amount);
        System.out.println("Thank you!");
    }

    
}
