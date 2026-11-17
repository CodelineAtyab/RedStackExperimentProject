public class Main {

    public static void main(String[] args) {

        RemoteCover remote = new LGTVRemote();

        // Change LGTVRemote to LGACRemote to demonstrate polymorphism.

        remote.placeButtons();
        remote.getInfoFromScreen();

        System.out.println("Turning ON...");
        remote.turnOn();

        System.out.println("Counter UP...");
        remote.turnCounterUp();

        System.out.println("Counter DOWN...");
        remote.turnCounterDown();

        System.out.println("Turning OFF...");
        remote.turnOff();
    }
}