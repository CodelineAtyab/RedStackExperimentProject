public class WalletPayment extends PaymentMethod {

    @Override
    public void pay(double walletAmount) {
        String formattedAmount = String.format("%.2f", walletAmount);
        System.out.println("Paid OMR " + formattedAmount + " from wallet");
    }
}