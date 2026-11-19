import java.util.ArrayList;
public class Main {



    public static void main(String[] args){

        Checkout checkout;
        WalletPayment walletPayment=new WalletPayment();
        CardPayment cardPayment=new CardPayment();
        BankTransferPayment bankTransferPayment=new BankTransferPayment();
        CashOnDeliveryPayment cashOnDeliveryPayment=new CashOnDeliveryPayment();

    ArrayList<PaymentMethod> alPaymentMethod=new ArrayList<>();

    alPaymentMethod.add(cardPayment);
    alPaymentMethod.add(walletPayment);
    alPaymentMethod.add(bankTransferPayment);
    alPaymentMethod.add(cashOnDeliveryPayment);


        for(PaymentMethod pm: alPaymentMethod){
        checkout=new Checkout(pm,25.0);
    }



    }
}