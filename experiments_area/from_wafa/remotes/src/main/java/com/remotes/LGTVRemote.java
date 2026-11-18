package com.remotes;

public class LGTVRemote extends RemoteCover {
    @Override
    public String getInfoFromScreen() {
        return "Power: %s | Channel: %d".formatted(PowerState ? "ON " : "OFF", Counter);
    }

    @Override
    public Boolean turnOn() {
        PowerState = true;
        System.out.println("Turning ON...");
        return PowerState;
    }

    @Override
    public Boolean turnOff() {
        PowerState = false;
        System.out.println("Turning OFF...");
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

    private String Device = "LG TV";
    private boolean PowerState = false;
    private int Counter = 1;
}