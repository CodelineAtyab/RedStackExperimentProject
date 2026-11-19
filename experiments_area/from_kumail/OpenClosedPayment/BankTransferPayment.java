public class BankTransferPayment extends PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid OMR " + String.format("%.2f", amount) + " by bank transfer");
    }
}
