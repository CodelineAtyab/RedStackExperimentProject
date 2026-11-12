
package com.DualRemoteSimulator;

public class LGACRemote extends RemoteCover {

    // Encapsulated attributes
    private boolean power;
    private int temperature;
    private final String coolingMode;

    public LGACRemote() {
        this.power = false;
        this.temperature = 24;
        this.coolingMode = "COOL";
    }

    // Private helper methods: Encapsulation
    private void powerToggle(boolean state) {
        power = state;
    }

    private void increaseTemperature() {
        if (temperature < 30) {
            temperature++;
        }
    }

    private void decreaseTemperature() {
        if (temperature > 16) {
            temperature--;
        }
    }

    private void displayStatus() {
        System.out.println(
                String.format(
                        "Power: %-3s | Temperature: %d°C | Mode: %s",
                        power ? "ON" : "OFF",
                        temperature,
                        coolingMode
                )
        );
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println("==== LG AC Remote ====");
        displayStatus();
    }

    @Override
    public void turnOn() {
        System.out.println("Turning AC ON...");
        powerToggle(true);
        displayStatus();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning AC OFF...");
        powerToggle(false);
        displayStatus();
    }

    @Override
    public void turnCounterUp() {
        if (power) {
            decreaseTemperature();
            System.out.println(
                    "Temperature Down -> " + temperature + "°C"
            );
        } else {
            System.out.println("AC is OFF. Cannot change temperature.");
        }
        displayStatus();
    }

    @Override
    public void turnCounterDown() {
        if (power) {
            increaseTemperature();
            System.out.println(
                    "Temperature Up -> " + temperature + "°C");
        }
        }


    @Override
    public void placeButtons(){

    }

}

