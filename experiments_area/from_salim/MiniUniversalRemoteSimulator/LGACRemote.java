public class LGACRemote extends RemoteCover {

    @Override
    public String getInfoFromScreen() {
        return "Power: %-3s | Temperature: %d".formatted(power ? "ON" : "OFF", temperature);

    }

    @Override
    public void turnOn() {
        power = true;
        System.out.println("Turning ON...");
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void turnOff() {
        power = false;
        System.out.println("Turning OFF...");
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void turnCounterUp() {
        temperature++;
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void turnCounterDown() {
        temperature--;
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void placeButtons() {
        System.out.println("[Power] [Temperature +] [Temperature -]");
    }

    private boolean power = false;
    private int temperature = 24;
}