
package com.PaymentAndPhone.PhoneCompositionAggregation;

public class Smartphone {

    private String model;
    private Battery battery;
    private SimCard simCard;

    public Smartphone(String model) {
        this.model = model;

        // Composition: smartphone creates its own battery
        this.battery = new Battery();

        // Initially, there is no SIM card
        this.simCard = null;
    }

    // Aggregation: receive an existing SIM card
    public void insertSim(SimCard simCard) {
        this.simCard = simCard;
    }

    // Remove SIM without destroying the object
    public void removeSim() {
        this.simCard = null;
    }

    public void makeCall(int minutes) {

        if (simCard == null) {
            System.out.println(model + ": no SIM card");
            return;
        }

        battery.drain(minutes * 2);

        System.out.println(
                model + " called for " + minutes
                        + " min using " + simCard.getNumber()
                        + ", battery " + battery.getLevel() + "%"
        );
    }

    public void printStatus() {

        String simNumber;

        if (simCard == null) {
            simNumber = "none";
        } else {
            simNumber = simCard.getNumber();
        }

        System.out.println(
                model + " | Battery: " + battery.getLevel()
                        + "% | SIM: " + simNumber
        );
    }
}
