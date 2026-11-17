package remotes;

public class LGTVRemote extends RemoteCover {
    private boolean isOn = false;
    private int channel = 1;

    private void validatePower(String action) {
        if (!isOn) {
            System.out.printf("[TV] Cannot %s. The TV is currently OFF.%n", action);
        }
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println("==== LG TV Remote ====");
        System.out.printf("Power: %-3s | Channel: %d%n", (isOn ? "ON" : "OFF"), channel);
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Turning ON...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Turning OFF...");
    }

    @Override
    public void turnCounterUp() {
        if (isOn) {
            channel++;
            System.out.printf("Channel Up -> %d%n", channel);
        } else {
            validatePower("increase channel");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isOn) {
            if (channel > 1) {
                channel--;
            }
            System.out.printf("Channel Down -> %d%n", channel);
        } else {
            validatePower("decrease channel");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("[TV Layout] Power, Channel Up/Down, Volume, Number Pad configured.");
    }
}