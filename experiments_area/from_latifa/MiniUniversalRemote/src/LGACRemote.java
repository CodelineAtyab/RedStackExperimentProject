public class LGACRemote extends RemoteCover {

    private boolean powerOn=false;
    private int temperature=24;
    private String coolingMode="COOL";


    @Override
    public void getInfoFromScreen() {
        displayStatus();
    }

    @Override
    public void turnOn() {
        powerOn = true;
        System.out.println("Turning ON...");
        displayStatus();
    }

    @Override
    public void turnOff() {
        powerOn = false;
        System.out.println("Turning OFF...");
        displayStatus();
    }

    @Override
    public void turnCounterUp() {
        if(powerOn){
            temperature++;
            System.out.println("Temperature Up -> " + temperature);
        }else {
            System.out.println("Can Not Change Temperature, AC is OFF");
        }
        displayStatus();
    }

    @Override
    public void turnCounterDown() {
        if(powerOn){
            temperature--;
            System.out.println("Temperature Down -> " + temperature);
        }else {
            System.out.println("Can Not Change Temperature, AC is OFF");
        }
        displayStatus();
    }

    @Override
    public void placeButtons() {
        System.out.println("==== LG AC Remote ====");
        System.out.println("Buttons: Power | Temperature Up | Temperature Down");
        System.out.println("Cooling Mode: " + coolingMode);
    }

    private void displayStatus() {
        System.out.println(String.format(
                "Power: %-3s | Temperature: %d°C",
                powerOn ? "ON" : "OFF", temperature
        ));
    }
}

