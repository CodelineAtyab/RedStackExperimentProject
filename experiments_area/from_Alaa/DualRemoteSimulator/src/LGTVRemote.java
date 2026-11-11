public class LGTVRemote extends RemoteCover {

    // Private fields (encapsulation)
    private boolean powerOn = false;
    private int channel = 1;
    private final int volume = 15;

    // Display TV information
    @Override
    public void getInfoFromScreen() {
        printStatus();
    }

    // Turn TV on
    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning TV ON...");
        printStatus();
    }

    // Turn TV off
    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning TV OFF...");
        printStatus();
    }

    // Increase channel
    @Override
    public void turnCounterUp() {
        if (powerOn) { // meaninig its true
            increaseChannel();
            System.out.println("Channel Up -> " + channel);
        } else {
            System.out.println("TV is OFF. Cannot change channel.");
        }

        printStatus();
    }

    // Decrease channel
    @Override
    public void turnCounterDown() {
        if (powerOn) {
            decreaseChannel();
            System.out.println("Channel Down -> " + channel);
        } else {
            System.out.println("TV is OFF. Cannot change channel.");
        }

        printStatus();
    }

    // Display TV remote buttons
    @Override
    public void placeButtons() {
        System.out.println("==== LG TV Remote Buttons ====");
        System.out.println("[POWER] [CHANNEL +] [CHANNEL -]");
        System.out.println("[VOLUME: 15]");
        printStatus();
    }

    // Private helper methods, so no external class can change such values
    private void increaseChannel() {
        channel++;
    }

    private void decreaseChannel() {
        if (channel > 1) {
            channel--;
        }
    }

    private void printStatus() {
        System.out.println(String.format("Device: LG TV | Power State: %s | Counter Value: %d | Volume: %d", powerOn ? "ON" : "OFF", channel, volume));
    }
}
