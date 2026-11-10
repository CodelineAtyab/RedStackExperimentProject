public class LGTVRemote extends RemoteCover {

    @Override
    public String getInfoFromScreenDisplay() {
        return "Channel #:"+channel+"  Volume %%:" + 55;
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
        return ++channel;
    }

    @Override
    public Integer turnCounterDown() {
        return --channel;
    }

    public Boolean turnPowerToggle() {
        System.out.println("Check the existing state");
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

