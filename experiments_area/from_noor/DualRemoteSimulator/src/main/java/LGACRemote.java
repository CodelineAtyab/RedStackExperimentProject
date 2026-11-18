public class LGACRemote extends RemoteCover {

    private boolean powerOn = false;
    private int temperature = 24;
    private final String mode = "COOL";

    private void powerToggle(boolean state) {
        powerOn = state;
    }

    private void changeTemperature(int amount) {
        if (powerOn) {
            temperature = Math.max(16, Math.min(30, temperature + amount));
        }
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println(String.format(
                "Device: LG AC | Power: %s | Temperature: %d°C | Mode: %s",
                powerOn ? "ON" : "OFF", temperature, mode));
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
        changeTemperature(1);
        getInfoFromScreen();
    }

    @Override
    public void turnCounterDown() {
        changeTemperature(-1);
        getInfoFromScreen();
    }

    @Override
    public void placeButtons() {
        System.out.println("LG AC Buttons: Power, Temperature Up, Temperature Down");
    }
}