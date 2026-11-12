package remotes;
public class LGACRemote extends RemoteCover {


    // store the state of AC, temperature and coolingMode
    private boolean powerOn =false;
    private  int temperature = 24;
    private boolean coolingMode = true ;


    // here to display the AC information
    @Override
    public void getInfoFromScreen(){


        System.out.println(String.format("Power State: %s | Counter Value: %d", powerOn ? "ON" : "OFF", temperature));

        System.out.println("Cooling Mode: " + (coolingMode ? "ON" : "OFF"));

    }
    //change the power of the AC
    private void powerToggle(boolean state){
        powerOn= state;
    }

    // increase the temperature by one
    private void increaseTemperature(){

        temperature++;
    }
    // decrease the temperature by one
    private void  decreaseTemperature(){
        temperature --;

    }

    // here to turn ON the AC
    @Override
    public void turnOn(){
        // change the power to ON
        powerToggle(true);
        System.out.println("Turning ON...");
        // displays the AC information
        getInfoFromScreen();

    }
    // here to turn OFF the AC
    @Override
    public void turnOff() {
        powerToggle(false);
        System.out.println("Turning OFF...");
        getInfoFromScreen();

    }
    //  here to increases the temperature and returns the new value
    @Override
    public Integer turnCounterUp(){
        increaseTemperature ();
        System.out.println("Temperature Up -> " + temperature );

        return temperature;
    }

    //  here to decrease the temperature and returns the new value
    @Override
    public Integer turnCounterDown(){
        decreaseTemperature();
        System.out.println("Temperature Down -> " + temperature );

        return temperature;
    }

    @Override
    public void placeButtons(){
        System.out.println("==== LG AC Remote ====");

    }

    // here to changes the cooling mode to the opposite state
    public void changeCoolingMode(){
     coolingMode= ! coolingMode;
        System.out.println("Cooling Mode: " + (coolingMode ? "ON" : "OFF"));
    }

}















