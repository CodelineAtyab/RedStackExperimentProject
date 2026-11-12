public class LGTVRemote extends RemoteCover {
    private static final int MIN_CHANNEL = 1;
    private static final int MAX_CHANNEL = 99;
    private static final int FIXED_VOLUME = 10;

    private boolean powerOn = false;
    private int channel = MIN_CHANNEL;

    @Override
    public String getInfoFromScreen() {
        return formatStatus("LG TV", powerOn, "Channel", channel)
                + " | Volume: %d".formatted(FIXED_VOLUME);
    }

    @Override
    public void turnOn() {
        if (!powerOn) {
            System.out.println("Turning ON...");
            powerToggle();
        } else {
            System.out.println("TV is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (powerOn) {
            System.out.println("Turning OFF...");
            powerToggle();
        } else {
            System.out.println("TV is already OFF.");
        }
    }

    @Override
    public void turnCounterUp() {
        if (!powerOn) {
            System.out.println("TV is OFF, turn it on first.");
            return;
        }
        changeChannel(+1);
        System.out.println("Channel Up -> " + channel);
    }

    @Override
    public void turnCounterDown() {
        if (!powerOn) {
            System.out.println("TV is OFF, turn it on first.");
            return;
        }
        changeChannel(-1);
        System.out.println("Channel Down -> " + channel);
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG TV Remote ====");
        System.out.println("Buttons: [POWER ON] [POWER OFF] [CH +] [CH -]");
    }

    private void powerToggle() {
        powerOn = !powerOn;
    }

    private void changeChannel(int step) {
        channel += step;
        if (channel > MAX_CHANNEL) {
            channel = MIN_CHANNEL;
        } else if (channel < MIN_CHANNEL) {
            channel = MAX_CHANNEL;
        }
    }
}