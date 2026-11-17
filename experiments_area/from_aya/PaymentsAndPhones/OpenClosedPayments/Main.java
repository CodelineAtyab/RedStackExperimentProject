package com.PaymentsAndPhones.OpenClosedPayments;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PaymentMethod> payments = new ArrayList<>();

        payments.add(new CardPayment());
        payments.add(new WalletPayment());
        payments.add(new BankTransferPayment());
        payments.add(new CashOnDeliveryPayment());

        Checkout checkout = new Checkout();

        for (PaymentMethod method : payments) {

            checkout.checkout(method, 25.0);

        }
    }
}