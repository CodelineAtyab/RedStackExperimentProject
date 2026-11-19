public abstract class RemoteCover {

    public abstract String getInfoFromScreen();
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void turnCounterUp();
    public abstract void turnCounterDown();
    public abstract void placeButtons();

    protected String formatStatus(String device, boolean powerOn, String counterName, int counter) {
        return "[%s] Power: %-3s | %s: %d".formatted(device, powerOn ? "ON" : "OFF", counterName, counter);
    }
}