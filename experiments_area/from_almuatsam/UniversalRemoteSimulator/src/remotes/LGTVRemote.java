package remotes;
public class LGTVRemote extends RemoteCover {

    private boolean powerOn;          // power state
    private int channel = 1;          // channel starts at 1
    private final int volume;         // fixed volume

    public LGTVRemote() {
        this.powerOn = false;         // TV starts off
        this.volume = 10;             // final: set once
    }

    // Show device, power, channel and volume
    @Override
    public void getInfoFromScreen() {
        String status = String.format(
            "Device: %s | Power: %s | Channel: %d | Volume: %d",
            "LG TV", getPowerText(), channel, volume
        );

        System.out.println(status);
    }

    @Override
    public void turnOn() {
        powerOn = true;
    }

    @Override
    public void turnOff() {
        powerOn = false;
    }

    // Channel +1 (only when the TV is on)
    @Override
    public void turnCounterUp() {
        if (isReady()) {
            channel++;
        }
    }

    // Channel -1 (never below 1)
    @Override
    public void turnCounterDown() {
        if (isReady() && channel > 1) {
            channel--;
        }
    }

    // Print the button layout
    @Override
    public void placeButtons() {
        System.out.println("+---------------------+");
        System.out.println("| [ON]          [OFF] |");
        System.out.println("|                     |");
        System.out.println("|    [CH +]  [CH -]   |");
        System.out.println("|                     |");
        System.out.println("|    [VOL]   [INFO]   |");
        System.out.println("+---------------------+");
    }

    // Helper: power as text
    private String getPowerText() {
        return powerOn ? "ON" : "OFF";
    }

    // Helper: channel buttons only work when the TV is on
    private boolean isReady() {
        if (!powerOn) {
            System.out.println("TV is off. Turn it on first.");
        }
        return powerOn;
    }
}






