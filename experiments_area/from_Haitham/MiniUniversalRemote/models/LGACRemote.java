package models;
public class LGACRemote extends RemoteCover {
    @Override
    public String getInfoFromScreenDisplay() {
        return "State: ON  Temperature: %d".formatted(temp);    }

    @Override
    public Boolean turnOn() {
        turnPowerToggle();
        System.out.println("Turning ON...");
        return true;
    }

    @Override
    public Boolean turnOff() {
        turnPowerToggle();
        System.out.println("Turning OFF...");
        return true;
    }

    @Override
    public Integer turnCounterUp() {
        return increaseTemperature();
    }

    @Override
    public Integer turnCounterDown() {
        return decreaseTemperature();
    }
    @Override
    public void placeButton() {
        System.out.println("==== LG AC Remote ====");
        System.out.println("AC buttons: Power, Temp Up/Down");
    }
    private Integer increaseTemperature() {
        return ++temp;
    }

    private Integer decreaseTemperature() {
        return --temp;
    }
    public Boolean turnPowerToggle() {
        if (!toggle) {
            toggle = true;
        } else {
            toggle = false;
        }
        return toggle;
    }
    private Boolean toggle = false;
    private Integer temp = 0;
}

