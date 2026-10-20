public class FanExperiment {
    public boolean isFanOn = false;
    public double speed = 0;

    public static void main(String[] args) {
        FanExperiment fan = new FanExperiment();
        fan.powerOn();
        fan.setSpeed(3.45);
        System.out.println("Fan is on: " + fan.isFanOn);
        System.out.println("Fan speed: " + fan.speed);
    }

    public void powerOn() {
        isFanOn = true;
    }
    public void powerOff() {
        isFanOn = false;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    
}
