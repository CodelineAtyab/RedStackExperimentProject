public class CardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implementation for card payment
        System.out.println("Processing card payment of $" + amount);
    }
    
}
