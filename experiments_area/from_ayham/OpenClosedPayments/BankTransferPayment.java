public class BankTransferPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implementation for bank transfer payment
        System.out.println("Processing bank transfer payment of $" + amount);
    }
    
}
