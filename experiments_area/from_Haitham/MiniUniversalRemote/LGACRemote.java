public class LGACRemote extends RemoteCover {

    private static String DEVICE = "LG AC";

    private boolean powerOn = false;
    private int temperature = 24;

    @Override
    public String getInfoFromScreen() {
        return "Device: %s | Power: %s | Temperature: %d "
                .formatted(DEVICE, powerOn ? "ON" : "OFF", temperature);
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
        return ++temperature;
    }

    @Override
    public int turnCounterDown() {
        return --temperature;
    }

    @Override
    public void placeButtons() {
        System.out.println("==== " + DEVICE + " Remote ====");
        System.out.println("Buttons: Power, Temp Up, Temp Down");
    }

    private void setPower(boolean on) {
        powerOn = on;
    }
}
