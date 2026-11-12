public class Smartphone {


    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery();
        this.simCard = null;
    }

    public void insertSim(SimCard simCard) {

        this.simCard = simCard;
    }
    public void removeSim(){

        this.simCard = null;
    }

    public void makeCall(int minutes){
        if(this.simCard == null){
            System.out.println(model+" no SIM card");
        }else {
            battery.drain(minutes*2);
            System.out.println(model + " called for " + minutes + " min using " + simCard.getNumber()
                    + ", battery " + battery.getLevel() + "%");
        }
    }

    public void printStatus() {
        String simNumber;
        if(simCard == null){
            simNumber="none";
        }else {
            simNumber=simCard.getNumber();
        }

        System.out.println(model + " | Battery: " + battery.getLevel() + "% | SIM: " + simNumber);
    }

    private String model;

    private Battery battery;

    private SimCard simCard;



}
