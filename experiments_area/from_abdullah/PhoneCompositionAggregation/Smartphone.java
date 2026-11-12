public class Smartphone {

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

    public void removeSim() {
        simCard = null;
    }

    public void makeCall(int minutes) {
        if (simCard == null) {
            System.out.println(model + ": no SIM card");
            return;
        }

        battery.drain(minutes * 2);

        System.out.println(model + " called for " + minutes
                + " min using " + simCard.getNumber()
                + ", battery " + battery.getLevel() + "%");
    }

    public void printStatus() {
        String number = "none";

        if (simCard != null) {
            number = simCard.getNumber();
        }

        System.out.println(model + " | Battery: "
                + battery.getLevel() + "% | SIM: " + number);
    }
}