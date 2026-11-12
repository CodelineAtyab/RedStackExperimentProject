public abstract class PaymentMethod {
    // Each payment type must provide its own way to process a payment.
    public abstract void pay(double paymentAmount);
}
