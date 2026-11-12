package remotes;

public class LGTVRemote extends RemoteCover {
    private boolean isTvOn = false;
    private int currentChannel = 1;
    private int fixedVolume = 10;

    @Override
    public void getInfoFromScreen() {
        System.out.println("\n==== LG TV Remote ====");

        System.out.println(String.format(
                "Device: %s | Power State: %s | Counter Value: %d",
                "LG TV",
                isTvOn ? "ON" : "OFF",
                currentChannel
        ));
        System.out.println("Volume: " + fixedVolume);
    }

    @Override
    public void turnOn() {
        powerToggle(true);
        getInfoFromScreen();
    }

    @Override
    public void turnOff() {
        powerToggle(false);
        getInfoFromScreen();
    }

    @Override
    public void turnCounterUp() {
        if (isTvOn) {
            currentChannel++;
            System.out.println("Channel Up -> " + currentChannel);
        } else {
            System.out.println("TV is OFF. Turn it ON first.");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isTvOn) {
            if (currentChannel > 1) {
                currentChannel--;
            }
            System.out.println("Channel Down -> " + currentChannel);
        } else {
            System.out.println("TV is OFF. Turn it ON first.");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("+----------------------+");
        System.out.println("|       LG TV          |");
        System.out.println("|      [ POWER ]       |");
        System.out.println("|   [ CH+ ]  [ CH- ]   |");
        System.out.println("|      [ VOL ]         |");
        System.out.println("+----------------------+");
    }

    private void powerToggle(boolean state) {
        isTvOn = state;
        if (state) {
            System.out.println("Turning ON...");
        } else {
            System.out.println("Turning OFF...");
        }
    }
}