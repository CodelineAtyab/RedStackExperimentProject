package remotes;

public class LGTVRemote extends RemoteCover {

    private boolean powerOn = false;
    private int channel = 1;
    private final int volume = 10;

    public void getInfoFromScreen() {
        System.out.println("\n==== LG TV Remote ====");
        System.out.println("Device: LG TV");
        System.out.println("Power State: " + (powerOn ? "ON" : "OFF"));
        System.out.println("Channel: " + channel);
        System.out.println("Volume: " + volume);
    }

    public void turnOn() {
        powerToggle(true);
        getInfoFromScreen();
    }

    public void turnOff() {
        powerToggle(false);
        getInfoFromScreen();
    }

    public void turnCounterUp() {
        if (!powerOn) {
            System.out.println("TV is OFF. Turn it ON first.");
            return;
        }

        channel++;
        System.out.println("Channel Up -> " + channel);
    }

    public void turnCounterDown() {
        if (!powerOn) {
            System.out.println("TV is OFF. Turn it ON first.");
            return;
        }

        if (channel > 1) {
            channel--;
        }

        System.out.println("Channel Down -> " + channel);
    }

    public void placeButtons() {
        System.out.println("""
                +----------------------+
                |       LG TV           |
                |   [ POWER ]           |
                | [ CH+ ]  [ CH- ]      |
                |   [ VOL ]             |
                +----------------------+
                """);
    }

    private void powerToggle(boolean state) {
        powerOn = state;
        System.out.println(state ? "Turning ON..." : "Turning OFF...");
    }
}
