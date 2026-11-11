package com.remotes;

public class LGACRemote extends RemoteCover {
    @Override
    public String getInfoFromScreen() {
        // Use ternary to show "ON" / "OFF" and adjust spacing to match the example
        String displayScreen = "Power: %s | Channel: %d".formatted(PowerState ? "ON " : "OFF", Counter);
        return displayScreen;
    }

    @Override
    public Boolean turnOn() {
        if (setPower(true)) {
            System.out.println("Turning ON...");
            PowerState = true;
        } else {
            PowerState = false;
        }
        return PowerState;
    }

    @Override
    public Boolean turnOff() {
        if (setPower(false)) {
            System.out.println("Turning OFF...");
            PowerState = false;
        } else {
            PowerState = true;
        }
        return PowerState;
    }

    @Override
    public Integer turnCounterUp() {
        return ++Counter;
    }

    @Override
    public Integer turnCounterDown() {
        return --Counter;
    }

    @Override
    public boolean placeButtons() {
        System.out.println("==== " + Device + " Remote ====");
        return false;
    }

    private boolean setPower(boolean ON) {
        PowerState = ON;
        return ON;
    }

    private String Device = "LG AC";
    private boolean PowerState = false;
    private int Counter = 20;
}