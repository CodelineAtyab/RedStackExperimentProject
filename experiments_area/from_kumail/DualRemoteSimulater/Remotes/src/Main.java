
import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {

    public static void main(String[] args) {

        // Change this one line to switch between devices.

        // RemoteCover remote = new LGTVRemote();
        RemoteCover remote = new LGACRemote();
        
        remote.placeButtons();

        remote.getInfoFromScreen();

        remote.turnOn();

        remote.turnCounterUp();

        remote.turnCounterDown();

        remote.turnOff();
    }
}
