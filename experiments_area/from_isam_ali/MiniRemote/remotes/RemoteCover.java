public abstract class RemoteCover {

    private String deviceName;
    private boolean powerOn;

    protected RemoteCover(String deviceName) {
        this.deviceName = deviceName;
    }

    public abstract void getInfoFromScreen();
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void turnCounterUp();
    public abstract void turnCounterDown();
    public abstract void placeButtons();

    protected void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    protected String getDeviceName() {
        return deviceName;
    }

    protected String powerLabel() {
        return powerOn ? "ON " : "OFF";
    }

    protected boolean isPowerOn() {
        return powerOn;
    }
}