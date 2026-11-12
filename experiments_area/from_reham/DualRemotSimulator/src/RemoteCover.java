public abstract class RemoteCover {
    /*
    abstract class -> a class that acts as a blueprint. 
    
    We cannot create an object directly from it.
        (but we use it as a refernce type) 

    abstract -> The child class must implemet it 
    */
    public abstract String getInfoFromScreen(); //Display information
    public abstract void turnOn(); //Turn on 
    public abstract void turnOff(); //Turn off
    public abstract void turnCounterUp(); //Increase Counter 
    public abstract void turnCounterDown(); //Decrease Counter
    public abstract void placeButtons(); //Place Buttons 
    
}
