package com.PaymentAndPhone.OpenClosePrinciple;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        paymentMethods.add(new CardPayment());
        paymentMethods.add(new WalletPayment());
        paymentMethods.add(new BankTransferPayment());

        // Adding a new payment method requires no changes to Checkout
        // because Checkout works with the abstract PaymentMethod type.
        paymentMethods.add(new CashOnDeliveryPayment());

        Checkout checkout = new Checkout();

        for (PaymentMethod method : paymentMethods) {
            checkout.checkout(method, 25.0);
        }
    }
}