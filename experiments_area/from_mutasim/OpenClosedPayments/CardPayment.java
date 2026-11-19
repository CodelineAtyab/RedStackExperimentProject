public class CardPayment extends PaymentMethod {

    @Override
    public void pay(double cardAmount) {
        String formattedAmount = String.format("%.2f", cardAmount);
        System.out.println("Paid OMR " + formattedAmount + " by card");
    }
}