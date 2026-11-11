public class CarPayment extends PaymentMethod{

    @Override
    public static void pay(double amount){
        System.out.println("Paid " + amount + " OMR by card");
    }
}