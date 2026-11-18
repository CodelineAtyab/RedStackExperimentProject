public class Checkout {
    public void checkout(PaymentMethod paymentOption, double totalAmount) {
        String formattedAmount = String.format("%.2f", totalAmount);
        System.out.println("Checkout: OMR " + formattedAmount);
        paymentOption.pay(totalAmount);
        System.out.println("Thank you!");
    }
}