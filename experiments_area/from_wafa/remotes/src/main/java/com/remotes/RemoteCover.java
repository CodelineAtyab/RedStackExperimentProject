package com.remotes;


public abstract class RemoteCover {


    public abstract String getInfoFromScreen();
    public abstract Boolean turnOn();
    public abstract Boolean turnOff();
    public abstract Integer turnCounterUp();
    public abstract Integer turnCounterDown();
    public abstract boolean placeButtons();
}
