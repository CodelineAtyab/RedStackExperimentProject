public class Smartphone {
    private String model;
    private Battery battery;
    private SimCard simCard;

    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery();
        this.simCard = null;
    }

    public void insertSim(SimCard simCard){
        this.simCard = simCard;
    }

    public void removeSim(){
        this.simCard = null;
    }

    public void makeCall(int minutes){
        if(this.simCard == null){
            System.out.println(model + ": no SIM card");
            return;
        }
        else{
            battery.drain(minutes * 2);
            System.out.println(model + " called for " + minutes + " min using " + simCard.getNumber() + ", batter " + battery.getLevel() + "%");
        }
    }

    public void printStatus() {
        String simStatus = (simCard != null) ? simCard.getNumber() : "none";
        System.out.println(model + " | Battery: " + battery.getLevel() + "% | SIM: " + simStatus);
    }
}