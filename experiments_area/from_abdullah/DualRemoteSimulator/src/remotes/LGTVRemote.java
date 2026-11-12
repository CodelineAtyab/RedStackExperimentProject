package remotes;

public class LGTVRemote extends RemoteCover {

    private boolean powerOn = false;
    private int channel = 1;
    private final int volume = 20;

    private void increaseChannel() {
        channel++;
    }

    private void decreaseChannel() {
        if (channel > 1) {
            channel--;
        }
    }

    @Override
    public void getInfoFromScreen() {
        String powerState = "OFF";

        if (powerOn) {
            powerState = "ON";
        }

        System.out.println(String.format(
                "Device: LG TV | Power State: %s | Counter Value (Channel): %d | Volume: %d",
                powerState, channel, volume));
    }

    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning TV ON...");
        getInfoFromScreen();
    }

    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning TV OFF...");
        getInfoFromScreen();
    }

    @Override
    public void turnCounterUp() {
        if (powerOn) {
            increaseChannel();
            System.out.println("Channel Up");
        } else {
            System.out.println("Turn on the TV first.");
        }

        getInfoFromScreen();
    }

    @Override
    public void turnCounterDown() {
        if (powerOn) {
            decreaseChannel();
            System.out.println("Channel Down");
        } else {
            System.out.println("Turn on the TV first.");
        }

        getInfoFromScreen();
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG TV Remote ====");
        System.out.println("[ON] [OFF] [CHANNEL +] [CHANNEL -]");
        getInfoFromScreen();
    }
}