public class LGACRemote extends RemoteCover {

    private static final int MIN_TEMP = 16;   // lower limit
    private static final int MAX_TEMP = 30;   // upper limit

    private boolean powerOn;                  // power state
    private int temperature = 24;             // starts at 24
    private String coolingMode = "COOL";      // starts in COOL mode

    public LGACRemote() {
        this.powerOn = false;                 // AC starts off
    }

    // Show device, power, temperature and mode in one formatted line
    @Override
    public void getInfoFromScreen() {
        String status = String.format(
            "Device: %s | Power: %s | Temperature: %d C | Mode: %s",
            "AC", getPowerText(), temperature, coolingMode
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

    // Temperature +1 (max 30, only when the AC is on)
    @Override
    public void turnCounterUp() {
        if (isReady() && temperature < MAX_TEMP) {
            temperature++;
        }
    }

    // Temperature -1 (min 16, only when the AC is on)
    @Override
    public void turnCounterDown() {
        if (isReady() && temperature > MIN_TEMP) {
            temperature--;
        }
    }

    // Print the AC remote layout
    @Override
    public void placeButtons() {
        System.out.println("+-----------------------+");
        System.out.println("|  [ON]           [OFF] |");
        System.out.println("|                       |");
        System.out.println("|  [TEMP +]    [TEMP -] |");
        System.out.println("|                       |");
        System.out.println("|  [MODE]      [FAN]    |");
        System.out.println("|  [SWING]     [TIMER]  |");
        System.out.println("+-----------------------+");
    }

    // Helper: power as text
    private String getPowerText() {
        return powerOn ? "ON" : "OFF";
    }

    // Helper: temperature buttons only work when the AC is on
    private boolean isReady() {
        if (!powerOn) {
            System.out.println("AC is off. Turn it on first.");
        }
        return powerOn;
    }
}

