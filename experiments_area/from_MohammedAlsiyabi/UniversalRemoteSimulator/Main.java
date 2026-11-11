public class Main {
    public static void main(String[] args) {

        // Polymorphism: only this line decides which remote we use.
        RemoteCover remote = (args.length > 0 && args[0].equalsIgnoreCase("AC"))
                ? new LGACRemote() : new LGTVRemote();

        // Abstraction: from here on we only know the type RemoteCover.
        remote.placeButtons();
        System.out.println(remote.getInfoFromScreen());

        remote.turnOn();
        System.out.println(remote.getInfoFromScreen());

        remote.turnCounterUp();
        remote.turnCounterDown();

        remote.turnOff();
        System.out.println(remote.getInfoFromScreen());
    }
}