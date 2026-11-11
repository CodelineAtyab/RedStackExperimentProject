import java.util.Scanner;

public class LGTVRemote extends RemoteCover {

    public LGTVRemote(Boolean displayText) {

        this.displayText = displayText;
        System.out.println("==== LG TV Remote ====");

    }

    @Override
    public String getInfoFromScreen() {
        if (displayText)
            return "Power: " + (tvPowerState ? "ON" : "OFF") + " | Channel: " + channelCounter;
        else
            return "Channel #: [%d] Volume %%:[%d]".formatted(channelCounter < 0 ? 0 : channelCounter, 55);
    }

    @Override
    public int turnCounterDown() {
        if (displayText) {
            System.out.println("Channel Down -> " + (--channelCounter));
            return channelCounter;
        }

        else
            return --channelCounter;
    }

    @Override
    public Boolean turnoff() {
        if (displayText)
            System.out.println("Turning OFF...");
        togglePower();
        return true;
    }

    @Override
    public int turnCounterUp() {

        if (displayText) {
            System.out.println("Channel Up -> " + (++channelCounter));
            return channelCounter;

        } else
            return ++channelCounter;
    }

    @Override
    public Boolean turnon() {
        if (displayText)
        System.out.println("Turning ON...");
        

        togglePower();
    

        return true;
    }

    private Boolean togglePower() {
        // System.out.println("Check the existing state");
        if (!tvPowerState)
            tvPowerState = true;
        else
            tvPowerState = false;

        return tvPowerState;
    }

    @Override
    public void channelChanger(int inputValue) {

        if (inputValue == 1)
            turnCounterUp();
        else if (inputValue == 0)
            turnCounterDown();

    }

    private Boolean tvPowerState = false;
    private Boolean displayText = false;

    private int channelCounter = 1;
}
