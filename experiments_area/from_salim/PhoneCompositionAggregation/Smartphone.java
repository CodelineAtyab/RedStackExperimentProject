public class Smartphone {
    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery();
    }

    public void insertSim(SimCard simCard) {
        this.simCard = simCard;
    }

    public void removeSim() {
        this.simCard = null;
    }

    public void makeCall(int minutes) {
        if (simCard == null) {
            System.out.println(model + ": no SIM card");
            return;
        }

        battery.drain(minutes * 2);
        System.out.printf("%s called for %d min using %s, battery %d%%%n", model, minutes, simCard.getNumber(), battery.getLevel());
    }

    public void printStatus() {
        String number = simCard == null ? "none" : simCard.getNumber();
        System.out.printf("%s | Battery: %d%% | SIM: %s%n", model, battery.getLevel(), number);
    }

    private final String model;
    private final Battery battery;
    private SimCard simCard;
}