public class Car {
    String CarName;
    String CarModel;
    String CarColor;

    public void carHonk(boolean isHonk) {
        if (isHonk) {
            System.out.println("Car is Honking");
        } else {
            System.out.println("Car is not Honking");
        }

    }


    public String carSpeed(double speed){
        if(speed >= 130){
            return "Car is overspeeding";
        } else if(speed >= 0 && speed < 130){
            return "Car is going in normal speed";
        } else {
            return "Invalid speed value";
        }
    }
}
