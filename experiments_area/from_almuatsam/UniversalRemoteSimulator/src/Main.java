import remotes.LGACRemote;
import remotes.LGTVRemote;
import remotes.RemoteCover;

public class Main {

    public static void main(String[] args) {
        // 1. Read the choice from command-line arguments
        if (args.length != 1) {
            printUsage();
            return;
        }

        // 2-3. Parent type reference, assigned to a concrete remote
        RemoteCover remote = createRemote(args[0]);
        if (remote == null) {
            printUsage();
            return;
        }

        // 4-5. Same calls, whichever remote it is
        remote.placeButtons();
        remote.getInfoFromScreen();

        remote.turnOn();
        remote.turnCounterUp();
        remote.getInfoFromScreen();


        remote.turnCounterDown();
        remote.turnOff();
        remote.getInfoFromScreen();
    }

    // Helper: pick the remote from the user's choice
    private static RemoteCover createRemote(String choice) {
        if (choice.equalsIgnoreCase("TV")) {
            return new LGTVRemote();
        }
        if (choice.equalsIgnoreCase("AC")) {
            return new LGACRemote();
        }
        return null;                      // unknown choice
    }

    // Helper: show how to run the program
    private static void printUsage() {
        System.out.println("Usage: java Main <TV|AC>");
    }
}

