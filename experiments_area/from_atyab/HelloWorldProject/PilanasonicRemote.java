public class PilanasonicRemote {
    public static void main(String[] args) {
        System.out.println("Hello, Panasonic Remote!");
    }

    public void powerOn() {
        isRemoteOn = true;
        
    }

    public void powerOff() {
        isRemoteOn = false;
    }

    public String getTempearatureValue() {
        return currentRoomTemp;
    }

    public boolean isRemoteOn = false;
    public String currentRoomTemp = "32";
}