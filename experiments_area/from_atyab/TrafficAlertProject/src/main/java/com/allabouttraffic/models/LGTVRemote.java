package com.allabouttraffic.models;

public class LGTVRemote extends RemoteCover {

    @Override
    public String getInfoFromScreenDisplay() {
        // Placeholder in Formatted String
        return "Channel #: [%d] Volume %%: [%d]".formatted(channelCounter, 55);
    }

    @Override
    public Boolean turnOn() {
        turnPowerToggle();
        return true;
    }

    @Override
    public Boolean turnOff() {
        turnPowerToggle();
        return true;
    }

    @Override
    public Integer turnCounterUp() {
        return ++channelCounter;
    }

    @Override
    public Integer turnCounterDown() {
        return --channelCounter;
    }

    public Boolean turnPowerToggle() {
        System.out.println("Check the existing state");
        if (!tvPowerState) {
            tvPowerState = true;
        } else {
            tvPowerState = false;
        }
        return tvPowerState;
    }

    private Boolean tvPowerState = false;
    private int channelCounter = 0;
}
