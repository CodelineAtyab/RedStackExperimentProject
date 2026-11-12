public class LGTVRemote extends RemoteCover {

    private static String DEVICE = "LG TV";

    private boolean powerOn = false;
    private int channel = 1;

    @Override
    public String getInfoFromScreen() {
        return "Device: %s | Power: %s | Channel: %d"
                .formatted(DEVICE, powerOn ? "ON" : "OFF", channel);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON...");
        setPower(true);
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF...");
        setPower(false);
    }

    @Override
    public int turnCounterUp() {
        return ++channel;
    }

    @Override
    public int turnCounterDown() {
        return --channel;
    }

    @Override
    public void placeButtons() {
        System.out.println("==== " + DEVICE + " Remote ====");
        System.out.println("Buttons: Power, Channel Up, Channel Down");
    }

    private void setPower(boolean on) {
        powerOn = on;
    }
}
