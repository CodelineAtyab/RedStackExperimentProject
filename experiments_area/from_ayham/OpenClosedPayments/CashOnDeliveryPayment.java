public class CashOnDeliveryPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implementation for cash on delivery payment
        System.out.println("Processing cash on delivery payment of $" + amount);
    }
    
}
