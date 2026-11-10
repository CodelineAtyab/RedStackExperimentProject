
package remotes;

public class LGACRemote extends RemoteCover {

    private boolean powerOn = false;
    private int temperature = 24;
    private final String mode = "Cooling";

    public void getInfoFromScreen() {
        System.out.println("\n==== LG AC Remote ====");
        System.out.println("Device: LG Air Conditioner");
        System.out.println("Power State: " + (powerOn ? "ON" : "OFF"));
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Mode: " + mode);
    }

    @Override
    public void turnOn() {
        powerToggle(true);
        getInfoFromScreen();
    }

    public void turnOff() {
        powerToggle(false);
        getInfoFromScreen();
    }

    public void turnCounterUp() {
        if (!powerOn) {
            System.out.println("AC is OFF. Turn it ON first.");
            return;
        }

        increaseTemperature();
        System.out.println("Temperature Up -> " + temperature + "°C");
    }

    public void turnCounterDown() {
        if (!powerOn) {
            System.out.println("AC is OFF. Turn it ON first.");
            return;
        }

        decreaseTemperature();
        System.out.println("Temperature Down -> " + temperature + "°C");
    }

    public void placeButtons() {
        System.out.println("""
                +----------------------+
                |       LG AC           |
                |   [ POWER ]           |
                | [ TEMP+ ] [ TEMP- ]   |
                |   [ MODE ]            |
                +----------------------+
                """);
    }

    private void powerToggle(boolean state) {
        powerOn = state;
        System.out.println(state ? "Turning ON..." : "Turning OFF...");
    }

    private void increaseTemperature() {
        if (temperature < 30) {
            temperature++;
        }
    }

    private void decreaseTemperature() {
        if (temperature > 16) {
            temperature--;
        }
    }
}
