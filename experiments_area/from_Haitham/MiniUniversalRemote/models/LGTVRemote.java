package models;
public class LGTVRemote extends RemoteCover {

    @Override
    public String getInfoFromScreenDisplay() {
        return "Channel #: [%d] Volume %%: [%d]".formatted(channel, 55);    }

    @Override
    public Boolean turnOn() {
        turnPowerToggle();
        System.out.println("Turning ON...");
        return true;
    }

    @Override
    public Boolean turnOff() {
        turnPowerToggle();
        System.out.println("Turning OFF...");
        return true;
    }

    @Override
    public Integer turnCounterUp() {
        return ++channel;
    }

    @Override
    public Integer turnCounterDown() {
        return --channel;
    }
    @Override
    public void placeButton() {
        System.out.println("==== LG TV Remote ====");
        System.out.println("TV buttons: Power, Channel Up/Down");
    }

    public Boolean turnPowerToggle() {
        if (!toggle) {
            toggle = true;
        } else {
            toggle = false;
        }
        return toggle;
    }
    

    private Boolean toggle = false;
    private int channel = 0;
}

