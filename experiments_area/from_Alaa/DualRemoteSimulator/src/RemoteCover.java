public abstract class RemoteCover {

        // Every remote must implement these methods.
        // void means these methods do not return a value.

        public abstract void getInfoFromScreen();

        public abstract void turnOn();

        public abstract void turnOff();

        public abstract void turnCounterUp();

        public abstract void turnCounterDown();

        public abstract void placeButtons();
}
