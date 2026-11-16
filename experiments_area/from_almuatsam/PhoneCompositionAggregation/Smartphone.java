public class Smartphone {
    private static final int BATTERY_DRAIN_PER_MINUTE = 2;

    private final String model;
    private final Battery battery;
    private SimCard simCard;

    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery(); // composition: the phone creates and owns it
        this.simCard = null;          // aggregation: starts without a SIM
    }

    public void insertSim(SimCard simCard) {
        this.simCard = simCard;
    }

    public void removeSim() {
        this.simCard = null; // only drops the reference; the SIM object lives on
    }

    public void makeCall(int minutes) {
        if (simCard == null) {
            System.out.println(model + ": no SIM card");
            return;
        }
        battery.drain(minutes * BATTERY_DRAIN_PER_MINUTE);
        System.out.println(model + " called for " + minutes + " min using "
                + simCard.getNumber() + ", battery " + battery.getLevel() + "%");
    }

    public void printStatus() {
        String simNumber = (simCard == null) ? "none" : simCard.getNumber();
        System.out.println(model
                + " | Battery: " + battery.getLevel() + "%"
                + " | SIM: " + simNumber);
    }
}
