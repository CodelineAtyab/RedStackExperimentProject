package remotes;

public abstract class RemoteCover {

        // Every remote must implement these methods
        //void because they return nothing
        public abstract void getInfoFromScreen(); //Abstraction, creating a method without showing the implementation

        public abstract void turnOn();

        public abstract void turnOff();

        public abstract void turnCounterUp();

        public abstract void turnCounterDown();

        public abstract void placeButtons();
}


