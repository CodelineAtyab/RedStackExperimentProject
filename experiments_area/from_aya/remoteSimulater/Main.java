import remote.RemoteCover;
import remote.LGTVRemote;

public class Main {

    public static void main(String[] args) {

        RemoteCover remote = new LGTVRemote();

        remote.placeButtons();
        remote.getInfoFromScreen();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();

    
    }
}
