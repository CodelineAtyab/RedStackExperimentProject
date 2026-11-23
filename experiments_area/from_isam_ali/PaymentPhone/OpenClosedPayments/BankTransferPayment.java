public class BankTransferPayment  extends PaymentMethod {
    @Override
    public void pay(double amount){
        System.out.println("Paid " +String.format("%.2f",amount));
    }
}