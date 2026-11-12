package com.allabouttraffic.models;

public class ACRemote {
    public ACRemote() {
        this.powerState = false;
        this.currTemperature = 0;
        this.currModeIndex = 0;
        this.allModes = new String[]{"cool", "warm", "fan", "dry"};

        setSpecifics();
    }

    public void setSpecifics() {}
    public Integer[] getSpecifics() {return null;}

    public int increaseTemperature() {
        currTemperature = currTemperature + 1;
        return currTemperature;
    }

    public int decreaseTemperature() {
        currTemperature = currTemperature - 1;
        return currTemperature;
    }

    public String setMode() {
        currModeIndex = (currModeIndex + 1);
        if (currModeIndex >= allModes.length) {
            currModeIndex = 0;
        }

        return allModes[currModeIndex];
    }

    private boolean powerState;
    private int currTemperature;
    private int currModeIndex;
    private String[] allModes;
}
