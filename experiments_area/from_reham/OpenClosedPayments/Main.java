import java.util.ArrayList;
public class Main {
    
        public static void main(String[] args) {
    
            // Create an ArrayList of PaymentMethod
            ArrayList<PaymentMethod> methods = new ArrayList<>();
    
            // Add payment objects
            methods.add(new CardPayment());
            methods.add(new WalletPayment());
            methods.add(new BankTransferPayment());
    
            // Process every payment
            for (PaymentMethod method : methods) {
                checkout(method, 25.0);
            }
        }
    
        public static void checkout(PaymentMethod method, double amount) {
    
            System.out.println("Checkout: OMR " + String.format("%.2f", amount));
    
            method.pay(amount);
    
            System.out.println("Thank you!");
        }
}