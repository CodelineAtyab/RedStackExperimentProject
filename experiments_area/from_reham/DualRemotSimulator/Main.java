
public class Main {
     public static void main(String[] args) {
        //remoteCover remote = new LGTVRemote();

        RemoteCover remote = new LGACRemote();
        RemoteCover remot2 = new LGTVRemote();

        System.out.println(remote.getInfoFromScreen());
        remote.placeButtons();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.turnOff();
 
        
        System.out.println(remot2.getInfoFromScreen());
        remot2.placeButtons();
        remot2.turnOn();
        remot2.turnCounterUp();
        remot2.turnCounterDown();
        remot2.turnOff();
     }
}
