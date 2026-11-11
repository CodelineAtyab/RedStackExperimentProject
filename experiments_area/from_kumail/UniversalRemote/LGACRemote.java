
package remotes;

public class LGACRemote extends RemoteCover {

    private boolean powerOn = false;
    private int temperature = 24;
    private String mode = "Cooling";

    @Override
    public void getInfoFromScreen() {

        System.out.println("\n==== LG AC Remote ====");

        System.out.println(String.format(
                "Device: %s | Power State: %s | Counter Value: %d",
                "LG Air Conditioner",
                powerOn ? "ON" : "OFF",
                temperature
        ));

        System.out.println("Temperature: " + temperature + " C");
        System.out.println("Mode: " + mode);
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

        if (powerOn) {

            increaseTemperature();

            System.out.println("Temperature Up -> " + temperature + " C");

        } else {
            System.out.println("AC is OFF. Turn it ON first.");
        }
    }

    @Override
    public void turnCounterDown() {

        if (powerOn) {

            decreaseTemperature();

            System.out.println("Temperature Down -> " + temperature + " C");

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

        powerOn = state;

        if (state) {
            System.out.println("Turning ON...");
        } else {
            System.out.println("Turning OFF...");
        }
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
