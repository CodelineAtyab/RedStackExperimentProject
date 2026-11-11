
package remotes;

public class LGACRemote extends RemoteCover {

    // Private fields (encapsulation)
    private boolean powerOn = false;
    private int temperature = 24;
    private final String coolingMode = "COOL";

    // Display AC information
    @Override
    public void getInfoFromScreen() {
        printStatus();
    }

    // Turn AC on
    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning AC ON...");
        printStatus();
    }

    // Turn AC off
    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning AC OFF...");
        printStatus();
    }

    // Increase temperature
    @Override
    public void turnCounterUp() {
        if (powerOn) {
            increaseTemperature();
            System.out.println("Temperature Up -> " + temperature + " C");
        } else {
            System.out.println("AC is OFF. Cannot change temperature.");
        }

        printStatus();
    }

    // Decrease temperature
    @Override
    public void turnCounterDown() {
        if (powerOn) {
            decreaseTemperature();
            System.out.println("Temperature Down -> " + temperature + " C");
        } else {
            System.out.println("AC is OFF. Cannot change temperature.");
        }

        printStatus();
    }

    // Display AC remote buttons
    @Override
    public void placeButtons() {
        System.out.println("==== LG AC Remote Buttons ====");
        System.out.println("[POWER] [TEMP +] [TEMP -]");
        System.out.println("[MODE: COOL]");
        printStatus();
    }

    // Private helper methods
    private void increaseTemperature() { //why private
        if (temperature < 30) {
            temperature++;
        }
    }

    private void decreaseTemperature() {
        if (temperature > 16) {
            temperature--;
        }
    }

    private void printStatus() {
        System.out.println(String.format("Device: LG AC | Power State: %s | Counter Value: %d C | Mode: %s", powerOn ? "ON" : "OFF", temperature, coolingMode));
    }
}
