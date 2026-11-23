public class LGTVRemote extends RemoteCover {

    private boolean powerOn = false;
    private int channel = 1;
    private final int volume = 15;

    private void powerToggle(boolean state) {
        powerOn = state;
    }

    private void changeChannel(int amount) {
        if (powerOn) {
            channel = Math.max(1, channel + amount);
        }
    }

    @Override
    public void getInfoFromScreen() {
        System.out.println(String.format(
                "Device: LG TV | Power: %s | Channel: %d | Volume: %d",
                powerOn ? "ON" : "OFF", channel, volume));
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
        changeChannel(1);
        getInfoFromScreen();
    }

    @Override
    public void turnCounterDown() {
        changeChannel(-1);
        getInfoFromScreen();
    }

    @Override
    public void placeButtons() {
        System.out.println("LG TV Buttons: Power, Channel Up, Channel Down");
    }
}