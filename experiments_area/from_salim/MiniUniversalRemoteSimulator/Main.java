public class Main {
    public static void main(String[] args) {
        //RemoteCover remote = new LGTVRemote();
        RemoteCover remote = new LGACRemote();

        System.out.println(remote.getInfoFromScreen());
        remote.placeButtons();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();
    }
}