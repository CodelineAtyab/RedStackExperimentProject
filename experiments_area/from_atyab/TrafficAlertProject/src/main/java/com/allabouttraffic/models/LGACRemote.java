package com.allabouttraffic.models;

public class LGACRemote extends RemoteCover {
    @Override
    public String getInfoFromScreenDisplay() {
        return "State: ON  Temperature: %d".formatted(temperatureCounter);
    }

    @Override
    public Boolean turnOn() {
        return null;
    }

    @Override
    public Boolean turnOff() {
        return null;
    }

    @Override
    public Integer turnCounterUp() {
        return increaseTemperature();
    }

    @Override
    public Integer turnCounterDown() {
        return decreaseTemperature();
    }

    private Integer increaseTemperature() {
        return ++temperatureCounter;
    }

    private Integer decreaseTemperature() {
        return --temperatureCounter;
    }

    private Integer temperatureCounter = 0;
}
