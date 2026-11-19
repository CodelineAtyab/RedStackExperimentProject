package remotes;

public class LGACRemote extends RemoteCover {
    private boolean isOn = false;
    private int temperature = 24;

    @Override
    public void getInfoFromScreen() {
        String powerState = isOn ? "ON" : "OFF";
        System.out.printf("==== LG AC Remote ====\nPower: %s | Temperature: %d°C%n", powerState, temperature);
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
            temperature++;
            System.out.println("Temperature Up -> " + temperature + "°C");
        } else {
            System.out.println("AC Remote is OFF.");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isOn) {
            temperature--;
            System.out.println("Temperature Down -> " + temperature + "°C");
        } else {
            System.out.println("AC Remote is OFF.");
        }
    }

    @Override
    public void placeButtons() {
        System.out.println("Placing AC buttons.");
    }
}