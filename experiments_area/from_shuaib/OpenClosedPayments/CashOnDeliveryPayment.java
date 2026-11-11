public class CashOnDeliveryPayment extends PaymentMethod{

    @Override
    public static void pay(double amount){
        System.out.println("Paid " + amount + " OMR in cash when order is delivered");
    }
}