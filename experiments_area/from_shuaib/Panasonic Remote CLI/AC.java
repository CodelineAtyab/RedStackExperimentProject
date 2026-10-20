public class AC {

    int temperature = 24;

    public void acOn(boolean isOn) {
        if (isOn) {
            System.out.println("AC is turned ON.");
        } else {
            System.out.println("AC is turned OFF.");
        }
    }

    public int acTemperature() {
        return temperature;
    }
}
