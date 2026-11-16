package remotes;

public class LGACRemote extends RemoteCover {
    private boolean isAcOn = false;
    private int currentTemperature = 24;
    private String coolingMode = "Cooling";

    @Override
    public void getInfoFromScreen() {
        System.out.println("\n==== LG AC Remote ====");

        System.out.println(String.format(
                "Device: %s | Power State: %s | Counter Value: %d",
                "LG Air Conditioner",
                isAcOn ? "ON" : "OFF",
                currentTemperature
        ));
        System.out.println("Temperature: " + currentTemperature + " C");
        System.out.println("Mode: " + coolingMode);
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
        if (isAcOn) {
            increaseTemperature();
            System.out.println("Temperature Up -> " + currentTemperature + " C");
        } else {
            System.out.println("AC is OFF. Turn it ON first.");
        }
    }

    @Override
    public void turnCounterDown() {
        if (isAcOn) {
            decreaseTemperature();
            System.out.println("Temperature Down -> " + currentTemperature + " C");
        } else {
            System.out.println("AC is OFF. Turn it ON first.");
        }
    }

    @Override
    public void placeButtons() {

        System.out.println("+----------------------+");
        System.out.println("|       LG AC          |");
        System.out.println("|      [ POWER ]       |");
        System.out.println("| [ TEMP+ ] [ TEMP- ]  |");
        System.out.println("|      [ MODE ]        |");
        System.out.println("+----------------------+");
    }

    private void powerToggle(boolean state) {
        isAcOn = state;
        if (state) {
            System.out.println("Turning ON...");
        } else {
            System.out.println("Turning OFF...");
        }
    }

    private void increaseTemperature() {
        if (currentTemperature < 30) {
            currentTemperature++;
        }
    }

    private void decreaseTemperature() {
        if (currentTemperature > 16) {
            currentTemperature--;
        }
    }
}