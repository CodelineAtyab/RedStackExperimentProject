public class CashOnDeliveryPayment extends PaymentMethod{
    @Override 
    public void pay(double amount){
        System.out.printf("Paid OMR <%.2f> in Cash when the order arrives\n",amount);
    }
}
