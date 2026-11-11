import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {

    public static void main(String[] args) {

        // Two objects for the two remotes
        // to check for TV we jast change the LGACRemote to LGTVRemote
        RemoteCover remote = new LGACRemote();

        // Use the same methods for remote type AC
        remote.placeButtons();
        remote.getInfoFromScreen();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();


    }
}
