package com.PaymentAndPhone.PhoneCompositionAggregation;
public class Main {

    public static void main(String[] args) {

        // Create one SIM card
        SimCard sim = new SimCard("99112233");

        // Create two smartphones
        Smartphone phone1 = new Smartphone("PhoneA");
        Smartphone phone2 = new Smartphone("PhoneB");

        // Composition: each phone creates and owns its battery.
        // Aggregation: the same SIM can be moved between phones
        // because it exists independently of both phones.

        phone1.insertSim(sim);

        phone1.makeCall(10);
        phone1.printStatus();

        phone1.removeSim();

        phone1.makeCall(3);

        phone2.insertSim(sim);

        phone2.makeCall(5);
        phone2.printStatus();

        phone1.printStatus();

        System.out.println("SIM still exists: " + sim.getNumber());
    }
}
