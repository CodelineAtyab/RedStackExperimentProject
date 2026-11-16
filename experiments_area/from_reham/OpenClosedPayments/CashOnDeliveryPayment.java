public class CashOnDeliveryPayment extends PaymentMethod {
    @Override 
    public void pay(double amount){
        System.out.println("Paid OMR " + String.format("%.2f", amount) + " in cash when the order arrives");

    }

}
