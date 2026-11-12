public class Checkout {
   
   public void checkout(PaymentMethod paymentMethod, double amount) {
       System.out.println("Chckout: OMR " + String.format("%.2f", amount));
       paymentMethod.Pay(amount);
       System.out.println("Thank you!");
   }

}