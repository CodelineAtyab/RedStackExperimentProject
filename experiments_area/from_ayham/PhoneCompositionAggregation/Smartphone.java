public class Smartphone {
    private String model;
    private Battery battery;
    private SimCard simCard;

    public Smartphone(String model, SimCard simCard) {
        this.model = model;
        this.battery = new Battery(100);
        this.simCard = simCard;
    }

    public void insertSim(SimCard simCard) {
        this.simCard = simCard;
    }

    public void removeSim() {
        this.simCard = null;
    }

    public void makeCall(int minutes) {
        if (simCard == null) {
            System.out.println("No SIM card inserted. Cannot make a call.");
            return;
        }
        else{
            int batteryDrain = minutes * 2; 
            battery.drain(batteryDrain);
            System.out.println(model + " called for " + minutes + " min using " + simCard.getNumber() + ", battery " + battery.getLevel() + "%");
        }
        
    }

    public void printStatus() {
        if (simCard != null) {
            System.out.println(model + " | Battery: " + battery.getLevel() + "% | SIM: " + simCard.getNumber());
        } else {
            System.out.println("No SIM card inserted.");
        }
    }
}
