public class LGACRemote extends RemoteCover {
    private static final int MIN_TEMP = 16;
    private static final int MAX_TEMP = 30;
    private static final String COOLING_MODE = "COOL";

    private boolean powerOn = false;
    private int temperature = 24;

    @Override
    public String getInfoFromScreen() {
        return formatStatus("LG AC", powerOn, "Temperature", temperature)
                + " | Mode: %s".formatted(COOLING_MODE);
    }

    @Override
    public void turnOn() {
        if (!powerOn) {
            System.out.println("Turning ON, cooling mode started...");
            powerToggle();
        } else {
            System.out.println("AC is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (powerOn) {
            System.out.println("Turning OFF...");
            powerToggle();
        } else {
            System.out.println("AC is already OFF.");
        }
    }

    @Override
    public void turnCounterUp() {
        if (!powerOn) {
            System.out.println("AC is OFF, turn it on first.");
            return;
        }
        if (increaseTemperature()) {
            System.out.println("Temperature Up -> " + temperature);
        } else {
            System.out.println("Maximum temperature reached (" + MAX_TEMP + ").");
        }
    }

    @Override
    public void turnCounterDown() {
        if (!powerOn) {
            System.out.println("AC is OFF, turn it on first.");
            return;
        }
        if (decreaseTemperature()) {
            System.out.println("Temperature Down -> " + temperature);
        } else {
            System.out.println("Minimum temperature reached (" + MIN_TEMP + ").");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG AC Remote ====");
        System.out.println("Buttons: [POWER ON] [POWER OFF] [TEMP +] [TEMP -]");
    }

    private void powerToggle() {
        powerOn = !powerOn;
    }

    private boolean increaseTemperature() {
        if (temperature < MAX_TEMP) {
            temperature++;
            return true;
        }
        return false;
    }

    private boolean decreaseTemperature() {
        if (temperature > MIN_TEMP) {
            temperature--;
            return true;
        }
        return false;
    }
}