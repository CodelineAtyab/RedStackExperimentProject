
package com.PaymentAndPhone.PhoneCompositionAggregation;

public class Battery {

    private int level = 100;

    // Package-private constructor
    Battery() {
    }

    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        level = Math.max(0, level - amount);
    }
}
