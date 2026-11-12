public class BankTransferPayment extends PaymentMethod {

    @Override
    public void pay(double transferAmount) {
        String formattedAmount = String.format("%.2f", transferAmount);
        System.out.println("Paid OMR " + formattedAmount + " by bank transfer");
    }
}