package remotes;

public class Main {
    public static void main(String[] args) {
        // Comment this to Switch Devices.
        // RemoteCover remote = new LGACRemote();
        RemoteCover selectedRemote = new LGTVRemote();
        selectedRemote.placeButtons();
        selectedRemote.getInfoFromScreen();
        selectedRemote.turnOn();
        selectedRemote.turnCounterUp();
        selectedRemote.turnCounterDown();
        selectedRemote.turnOff();
    }
}
