import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {

    public static void main(String[] args) {

        RemoteCover remote = new LGTVRemote(); // Change to new LGACRemote().

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("AC")) {
                remote = new LGACRemote();
            } else if (args[0].equalsIgnoreCase("TV")) {
                remote = new LGTVRemote();
            } else {
                System.out.println("Please choose TV or AC.");
                return;
            }
        }

        // These same calls run the methods of the selected remote.
        remote.placeButtons();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();
    }
}