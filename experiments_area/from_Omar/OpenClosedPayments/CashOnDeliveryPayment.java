public class CashOnDeliveryPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pay OMR " + String.format("%.2f", amount) + " in cash when the order arrives");
    }
}