public class CardPayment extends PaymentMethod{

    @Override
    public Double pay(double amount) {

        System.out.println("Paid OMR " + String.format("%.2f", amount) + " by card");
        return amount;
    }


}
