
package com.DualRemoteSimulator;

public class LGTVRemote extends RemoteCover {

    // Encapsulated attributes
    private boolean power;
    private int channel;


    public LGTVRemote() {
        this.power = false;
        this.channel = 1;
    }

    // Private helper method: Encapsulation
    private void powerToggle(boolean state) {
        power = state;
    }

    private void increaseChannel() {
        if (channel < 999) {
            channel++;
        }
    }

    private void decreaseChannel() {
        if (channel > 1) {
            channel--;
        }
    }

    private void displayStatus() {
        System.out.println(
                String.format(
                         "Power: %-3s | Channel: %d ", power ? "ON" : "OFF", channel
                )
        );
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println("==== LG TV Remote ====");
        displayStatus();
    }

    @Override
    public void turnOn() {
        System.out.println("Turning TV ON...");
        powerToggle(true);
        displayStatus();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning TV OFF...");
        powerToggle(false);
        displayStatus();
    }

    @Override
    public void turnCounterUp() {
        if (power) {
            increaseChannel();
            System.out.println("Channel Up -> " + channel);
        } else {
            System.out.println("TV is OFF. Cannot change channel.");
        }
        displayStatus();
    }

    @Override
    public void turnCounterDown() {
        if (power) {
            decreaseChannel();
            System.out.println("Channel Down -> " + channel);
        }
    }

    @Override
    public void placeButtons() {

    }
}

