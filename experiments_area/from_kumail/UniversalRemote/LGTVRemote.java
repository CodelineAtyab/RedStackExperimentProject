
package remotes;

public class LGTVRemote extends RemoteCover {

    private boolean powerOn = false;
    private int channel = 1;
    private int volume = 10;

    @Override
    public void getInfoFromScreen() {

        System.out.println("\n==== LG TV Remote ====");

        System.out.println(String.format(
                "Device: %s | Power State: %s | Counter Value: %d",
                "LG TV",
                powerOn ? "ON" : "OFF",
                channel
        ));

        System.out.println("Volume: " + volume);
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

        if (powerOn) {
            channel++;
            System.out.println("Channel Up -> " + channel);
        } else {
            System.out.println("TV is OFF. Turn it ON first.");
        }
    }

    @Override
    public void turnCounterDown() {

        if (powerOn) {

            if (channel > 1) {
                channel--;
            }

            System.out.println("Channel Down -> " + channel);

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

        powerOn = state;

        if (state) {
            System.out.println("Turning ON...");
        } else {
            System.out.println("Turning OFF...");
        }
    }
}
