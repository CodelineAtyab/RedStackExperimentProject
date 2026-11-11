public class Smartphone {
    private class Battery{
        private int level = 100;

         Battery() {
            this.level = 100;
        }

        public void drain(int amount) {
            level -= amount;
            if (level < 0) {
                level = 0;
            }
        }

        public int getLevel(){
            return level;
        }
        }
    private String model;

    private Battery battery;

    private SimCard simCard;

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
            System.out.println("no SIM card");
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


}


