import remotes.RemoteCover;
import remotes.LGTVRemote;
import remotes.LGACRemote;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify 'TV' or 'AC' as an argument.");
            return;
        }

        RemoteCover remote;

        if (args[0].equalsIgnoreCase("TV")) {
            remote = new LGTVRemote();
        } else if (args[0].equalsIgnoreCase("AC")) {
            remote = new LGACRemote();
        } else {
            System.out.println("Invalid option. Use 'TV' or 'AC'.");
            return;
        }

        remote.getInfoFromScreen();
        remote.turnOn();
        remote.getInfoFromScreen();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();
        remote.getInfoFromScreen();
    }
}