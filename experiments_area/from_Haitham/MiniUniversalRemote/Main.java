public class Main {

    public static void main(String[] args) {
        RemoteCover remote = new LGTVRemote();

        remote.placeButtons();

        System.out.println(remote.getInfoFromScreen());

        remote.turnOn();
        System.out.println(remote.getInfoFromScreen());

        System.out.println("Counter Up -> " + remote.turnCounterUp());
        System.out.println(remote.getInfoFromScreen());

        System.out.println("Counter Down -> " + remote.turnCounterDown());
        System.out.println(remote.getInfoFromScreen());

        remote.turnOff();
        System.out.println(remote.getInfoFromScreen());
    }
}
