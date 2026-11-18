public class CashOnDeliveryPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.printf("Pay OMR %.2f in cash when the order arrives%n", amount);
    }
}
