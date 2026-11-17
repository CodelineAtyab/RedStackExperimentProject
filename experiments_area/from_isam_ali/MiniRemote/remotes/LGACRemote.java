public class LGACRemote extends RemoteCover {

    private static final int MIN_TEMPERATURE = 16;
    private static final int MAX_TEMPERATURE = 30;
    private static final String MODE = "COOL"; // fixed cooling mode

    private int temperature = 24;

    public LGACRemote() {
        super("LG AC");
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
            System.out.println("AC is OFF - Temperature Up ignored.");
            return;
        }
        increaseTemperature();
        System.out.println("Temperature Up -> " + temperature);
    }

    @Override
    public void turnCounterDown() {
        if (!isPowerOn()) {
            System.out.println("AC is OFF - Temperature Down ignored.");
            return;
        }
        decreaseTemperature();
        System.out.println("Temperature Down -> " + temperature);
    }

    private void powerToggle(boolean on) {
        setPowerOn(on);
    }

    private void increaseTemperature() {
        if (temperature < MAX_TEMPERATURE) {
            temperature++;
        }
    }

    private void decreaseTemperature() {
        if (temperature > MIN_TEMPERATURE) {
            temperature--;
        }
    }

    private void printStatus() {
        System.out.println("Power: %s | Temperature: %d".formatted(powerLabel(), temperature));
    }
}