
public class LGTVRemote extends RemoteCover {

    // here to stores the power , channel and volume of the TV
    private boolean powerOn =false;
    private  int channel = 1;
    private int volume = 20 ;


    // displays the TV information
    @Override
    public void getInfoFromScreen(){
        System.out.println(String.format("Power State: %s | Counter Value: %d", powerOn ? "ON" : "OFF", channel));

       System.out.println("Volume: " + volume);

    }

    //here to changes the power state of the TV
    private void powerToggle(boolean state){
        powerOn= state;
    }

     private void increaseChannel(){

        channel++;
    }
    private void  decreaseChannel(){
        if(channel> 1){
            channel --;
        }
    }
    @Override
    public void turnOn(){
        powerToggle(true);
        System.out.println("Turning ON...");
        getInfoFromScreen();

    }
    @Override
    public void turnOff() {
        powerToggle(false);
        System.out.println("Turning OFF...");
        getInfoFromScreen();

    }
    @Override
    public Integer turnCounterUp(){
        increaseChannel();
        System.out.println("Channel Up -> " + channel);

        return 0;
    }

    @Override
    public Integer turnCounterDown(){
        decreaseChannel();
        System.out.println("Channel Down -> " + channel);

        return 0;
    }

    // print the title
    @Override
    public void placeButtons(){

        System.out.println("==== LG TV Remote ====");

    }
    }














