public class Main {


    public static void main(String[] args) {
        String choice = args.length > 0 ? args[0] : "TV";

        RemoteCover remote = choice.equalsIgnoreCase("AC") ? new LGACRemote() : new LGTVRemote();

        remote.placeButtons();
        remote.getInfoFromScreen();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();


    }








}