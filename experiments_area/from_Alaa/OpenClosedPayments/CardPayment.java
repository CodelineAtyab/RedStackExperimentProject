public class CardPayment extends PaymentMethod {
    @Override
    public void Pay(double amount) {
       System.out.println("Paid OMR " + String.format("%.2f", amount) + " using Card.");
    }
}