public class CashOnDeliveryPayment extends PaymentMethod {

    @Override
    public void pay(double cashAmount) {
        String formattedAmount = String.format("%.2f", cashAmount);
        System.out.println("Pay OMR " + formattedAmount + " in cash when the order arrives");
    }
}