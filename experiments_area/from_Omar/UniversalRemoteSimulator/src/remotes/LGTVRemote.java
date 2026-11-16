package remotes;

public class LGTVRemote extends RemoteCover {
    private boolean isOn = false;
    private int channel = 1;

    @Override
    public void getInfoFromScreen() {
        String powerState = isOn ? "ON" : "OFF";
        System.out.printf("==== LG TV Remote ====\nPower: %s | Channel: %d%n", powerState, channel);
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
            System.out.println("Channel Up -> " + channel);
        } else {
            System.out.println("Remote is OFF. Turn it on first.");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isOn && channel > 1) {
            channel--;
            System.out.println("Channel Down -> " + channel);
        } else if (!isOn) {
            System.out.println("Remote is OFF.");
        } else {
            System.out.println("Already at minimum channel.");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("Placing standard TV buttons.");
    }
}