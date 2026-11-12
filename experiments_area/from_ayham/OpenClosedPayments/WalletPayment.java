public class WalletPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implementation for wallet payment
        System.out.println("Processing wallet payment of $" + amount);
    }
    
}
