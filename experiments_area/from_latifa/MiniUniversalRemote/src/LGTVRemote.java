public class LGTVRemote extends RemoteCover {

    private boolean powerOn=false;
    private int channel =1;
    private final int volume=20;


    @Override
    public void getInfoFromScreen() {

        displayStatus();
    }

    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning ON...");
        displayStatus();
    }

    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning OFF...");
        displayStatus();
    }

    @Override
    public void turnCounterUp() {
        channel++;
        System.out.println("Channel Up -> " + channel);
    }

    @Override
    public void turnCounterDown() {
        if (channel > 1) {
            channel--;
        }
        System.out.println("Channel Down -> " + channel);
        displayStatus();
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG TV Remote ====");
        System.out.println("Buttons: Power | Channel Up | Channel Down");
        System.out.println("Fixed Volume: " + volume);
    }

    private void displayStatus() {
        System.out.println(String.format(
                "Power: %-3s | Channel: %d",
                powerOn ? "ON" : "OFF", channel
        ));
    }
}

