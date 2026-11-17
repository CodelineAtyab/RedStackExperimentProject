package com.remoteSimulater.remote;

public class LGACRemote extends RemoteCover {

        private int temperature = 24;
        private boolean power = false;
        private String coolingMode = "Cool";

        private void powerToggle() {
            power = !power;
        }

        private void increaseTemperature() {
            temperature++;
        }

        private void decreaseTemperature() {
            temperature--;
        }

        @Override
        public void getInfoFromScreen() {
            System.out.println("Power: " + (power ? "ON" : "OFF") + " | Temperature: " + temperature + "C" + " | Mode: " + coolingMode);
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
            increaseTemperature();
            System.out.println("Temperature Up -> " + temperature + "C");
        }

        @Override
        public void turnCounterDown() {
            decreaseTemperature();
            System.out.println("Temperature Down -> " + temperature + "C");
        }

        @Override
        public void placeButtons() {
            System.out.println("Buttons: Power | Temperature Up | Temperature Down");
        }
    }

