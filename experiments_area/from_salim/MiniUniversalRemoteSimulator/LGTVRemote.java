public class LGTVRemote extends RemoteCover {

    @Override
    public String getInfoFromScreen() {
        return "Power: %-3s | Channel: %d".formatted(power ? "ON" : "OFF", channel);
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
        channel++;
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void turnCounterDown() {
        if (channel > 1) {
            channel--;
        }
        System.out.println(getInfoFromScreen());
    }

    @Override
    public void placeButtons() {
        System.out.println("[Power] [Channel +] [Channel -]");
    }

    private boolean power = false;;
    private int channel = 1;
}