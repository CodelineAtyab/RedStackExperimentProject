public class LGTVRemote extends RemoteCover {

    private static final int MIN_CHANNEL = 1;
    private static final int MAX_CHANNEL = 99;
    private static final int FIXED_VOLUME = 20; // fixed, never changes

    private int channel = MIN_CHANNEL;

    public LGTVRemote() {
        super("LG TV");
    }

    @Override
    public void placeButtons() {
        System.out.println("==== " + getDeviceName() + " Remote ====");
    }

    @Override
    public void getInfoFromScreen() {
        printStatus();
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON...");
        powerToggle(true);
        printStatus();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF...");
        powerToggle(false);
        printStatus();
    }

    @Override
    public void turnCounterUp() {
        if (!isPowerOn()) {
            System.out.println("TV is OFF - Channel Up ignored.");
            return;
        }
        increaseChannel();
        System.out.println("Channel Up -> " + channel);
    }

    @Override
    public void turnCounterDown() {
        if (!isPowerOn()) {
            System.out.println("TV is OFF - Channel Down ignored.");
            return;
        }
        decreaseChannel();
        System.out.println("Channel Down -> " + channel);
    }

    private void powerToggle(boolean on) {
        setPowerOn(on);
    }

    private void increaseChannel() {
        channel = (channel >= MAX_CHANNEL) ? MIN_CHANNEL : channel + 1;
    }

    private void decreaseChannel() {
        channel = (channel <= MIN_CHANNEL) ? MAX_CHANNEL : channel - 1;
    }

    private void printStatus() {
        System.out.println("Power: %s | Channel: %d".formatted(powerLabel(), channel));
    }
}