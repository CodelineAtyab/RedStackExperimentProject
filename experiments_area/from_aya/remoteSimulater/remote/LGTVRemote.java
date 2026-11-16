package com.remoteSimulater.remote;

public class LGTVRemote extends RemoteCover {

    private int channel = 1;
    private boolean power = false;

    private void powerToggle() {
        power = !power;
    }

    private void increaseChannel() {
        channel++;
    }

    private void decreaseChannel() {
        if (channel > 1) {
            channel--;
        }
    }
    @Override
    public void getInfoFromScreen() {
        String powerState = power ? "ON " : "OFF";
        System.out.println("Power: " + powerState + " | Channel: " + channel);
    }
    @Override
    public void turnOn() {
        System.out.println("Turning ON...");
        powerToggle();
        getInfoFromScreen();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF...");
        powerToggle();
        getInfoFromScreen();
    }

    @Override
    public void turnCounterUp() {
        increaseChannel();
        System.out.println("Channel Up -> " + channel);
    }

    @Override
    public void turnCounterDown() {
        decreaseChannel();
        System.out.println("Channel Down -> " + channel);
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG TV Remote ====");
    }
}