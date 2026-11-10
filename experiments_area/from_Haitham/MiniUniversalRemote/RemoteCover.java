public abstract class RemoteCover {
    public abstract String getInfoFromScreenDisplay();
    public abstract Boolean turnOn();
    public abstract Boolean turnOff();

    public abstract Integer turnCounterUp();
    public abstract Integer turnCounterDown();
    public abstract void placeButton();
}
