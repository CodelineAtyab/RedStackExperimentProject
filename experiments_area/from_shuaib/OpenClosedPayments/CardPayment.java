public class CardPayment extends PaymentMethod{

    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " OMR by card");
    }
}