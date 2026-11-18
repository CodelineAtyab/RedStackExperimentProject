public class Smartphone {
    private String model;
    private Battery battery; // Composition field
    private SimCard simCard; // Aggregation field

    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery(); // Created internally (Composition)
        this.simCard = null;          // Starts with no SIM
    }

    public void insertSim(SimCard simCard) {
        this.simCard = simCard;
    }

    public void removeSim() {
        this.simCard = null; // Clears reference without destroying the SimCard object
    }

    public void makeCall(int minutes) {
        if (this.simCard == null) {
            System.out.println(model + ": no SIM card");
            return;
        }

        int drainAmount = minutes * 2;
        battery.drain(drainAmount);

        System.out.println(model + " called for " + minutes + " min using " + simCard.getNumber() + ", battery " + battery.getLevel() + "%");
    }

    public void printStatus() {
        String simInfo = (simCard != null) ? simCard.getNumber() : "none";
        System.out.println(model + " | Battery: " + battery.getLevel() + "% | SIM: " + simInfo);
    }
}