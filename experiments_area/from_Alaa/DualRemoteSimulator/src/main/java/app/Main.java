package app;

import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {

    public static void main(String[] args) {

        // Parent reference
        RemoteCover remoteAC = new LGACRemote();
        RemoteCover remoteTV = new LGTVRemote();

        // Use the same methods for remote type AC
        remoteAC.placeButtons();
        remoteAC.getInfoFromScreen();
        remoteAC.turnOn();
        remoteAC.turnCounterUp();
        remoteAC.turnCounterDown();
        remoteAC.turnOff();

        // Use the same methods for remote type TV
        remoteTV.placeButtons();
        remoteTV.getInfoFromScreen();
        remoteTV.turnCounterUp();
        remoteTV.turnCounterDown();
        remoteTV.turnOff();
        remoteTV.turnOn();
    }
}
