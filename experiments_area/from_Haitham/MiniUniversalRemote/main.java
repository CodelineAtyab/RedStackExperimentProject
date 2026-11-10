import models.RemoteCover;
import models.LGTVRemote;
import models.LGACRemote;
public class main {
    public static void main(String[] args) {
        RemoteCover remote = new LGTVRemote();
        
        remote.placeButton();
        remote.getInfoFromScreenDisplay();
        remote.turnOn();
        remote.turnCounterUp();
        remote.turnCounterDown();
        remote.getInfoFromScreenDisplay();
        remote.turnOff();

    }
}
