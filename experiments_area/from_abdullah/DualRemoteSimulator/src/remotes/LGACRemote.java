package remotes;

public class LGACRemote extends RemoteCover {

    private boolean powerOn = false;
    private int temperature = 24;
    private final String mode = "Cooling";

    private void increaseTemperature() {
        temperature++;
    }

    private void decreaseTemperature() {
        temperature--;
    }

    @Override
    public void getInfoFromScreen() {
        String powerState = "OFF";

        if (powerOn) {
            powerState = "ON";
        }

        System.out.println(String.format(
                "Device: LG AC | Power State: %s | Counter Value (Temperature): %d C | Mode: %s",
                powerState, temperature, mode));
    }

    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning AC ON...");
        getInfoFromScreen();
    }

    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning AC OFF...");
        getInfoFromScreen();
    }

    @Override
    public void turnCounterUp() {
        if (powerOn) {
            increaseTemperature();
            System.out.println("Temperature Up");
        } else {
            System.out.println("Turn on the AC first.");
        }

        getInfoFromScreen();
    }

    @Override
    public void turnCounterDown() {
        if (powerOn) {
            decreaseTemperature();
            System.out.println("Temperature Down");
        } else {
            System.out.println("Turn on the AC first.");
        }

        getInfoFromScreen();
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG AC Remote ====");
        System.out.println("[ON] [OFF] [TEMPERATURE +] [TEMPERATURE -]");
        getInfoFromScreen();
    }
}