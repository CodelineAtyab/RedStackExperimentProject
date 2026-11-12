package remotes;
public class Main {
    public static void main(String[] args) {


        //here to creates a RemoteCover reference
        RemoteCover remote;

        //to checks the selected remote type
        if (args[0].equalsIgnoreCase("TV")) {
            // here to creates LG TV remote
            remote = new LGTVRemote();

            // and here to creates LG AC remote
        } else {
            remote = new LGACRemote();
        }

        remote.placeButtons();
        remote.getInfoFromScreen();

        remote.turnOn();

        remote.turnCounterUp();
        remote.turnCounterDown();

        remote.turnOff();

    }
    }