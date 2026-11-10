package remotes;

public class LGACRemote extends RemoteCover {
    private boolean isOn = false;
    private int temperature = 24;

    private void validatePower(String action) {
        if (!isOn) {
            System.out.printf("[AC] Cannot %s. The AC is currently OFF.%n", action);
        }
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println("==== LG AC Remote ====");
        System.out.printf("Power: %-3s | Temperature: %d°C (Cooling Mode)%n", (isOn ? "ON" : "OFF"), temperature);
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Turning AC ON...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Turning AC OFF...");
    }

    @Override
    public void turnCounterUp() {
        if (isOn) {
            if (temperature < 30) {
                temperature++;
            }
            System.out.printf("Temperature Up -> %d°C%n", temperature);
        } else {
            validatePower("increase temperature");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isOn) {
            if (temperature > 16) {
                temperature--;
            }
            System.out.printf("Temperature Down -> %d°C%n", temperature);
        } else {
            validatePower("decrease temperature");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("[AC Layout] Power, Temp Up/Down, Fan Speed, Mode Selector configured.");
    }
}