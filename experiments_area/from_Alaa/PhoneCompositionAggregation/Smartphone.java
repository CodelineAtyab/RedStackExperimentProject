public class Smartphone{

    private String model;
    private Battery battery; //Smartphone object can hold a reference to a Battery object.
    private SimCard simCard;

    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery(); //because smartphone creates and owns the battery, it is responsible for creating and managing the battery object.
    }

    public void insertSim(SimCard simCard) {
        this.simCard = simCard; //assign the SIM object passed from outside to the Smartphone's simCard field.
    }

    public void removeSim() {
        this.simCard = null; //make the phone hold no SIM, which doesn't effect the SIM object from exesting.
    }

    public void makeCall(int minutes){
            if (this.simCard == null ){
            System.out.println(this.model + ": no SIM card");
            }
            else{
                int batteryDrain = minutes * 2; //drain 2% battery per minute of call
                if (this.battery.getLevel() >= batteryDrain){
                    this.battery.drain(batteryDrain);// call function from battery
                    System.out.println(this.model + " called for "+ minutes+ " min using " + this.simCard.getNumber() + ", Battery:  " + this.battery.getLevel() + "%");
                } else {
                    System.out.println(this.model + ": not enough battery to make the call. Battery level: " + this.battery.getLevel() + "%");
                }
            }
    }

    public void printStatus(){
        System.out.println(this.model + " | Battery: " + this.battery.getLevel() + "% | SIM: " + (this.simCard != null ? this.simCard.getNumber() : "none"));
    }


}