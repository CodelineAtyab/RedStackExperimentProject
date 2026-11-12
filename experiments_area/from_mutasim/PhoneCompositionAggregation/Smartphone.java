public class Smartphone {

    private final String model;
    private final Battery battery;
    private SimCard simCard;

    public Smartphone(String phoneModel) {
        this.battery = new Battery();
        this.model = phoneModel;
        this.simCard = null;
    }

    public void insertSim(SimCard newSim) {
        this.simCard = newSim;
    }

    public void removeSim() {
        this.simCard = null;
    }

    public void makeCall(int callMinutes) {

        if (simCard == null) {
            System.out.printf("%s: no SIM card%n", model);
            return;
        }
        battery.drain(callMinutes * 2);

        System.out.printf(
                "%s called for %d min using %s, battery %d%%%n",
                model,
                callMinutes,
                simCard.getNumber(),
                battery.getLevel()
        );
    }

    public void printStatus() {
        String currentSim = (simCard == null)
                ? "none"
                : simCard.getNumber();

        System.out.printf(
                "%s | Battery: %d%% | SIM: %s%n",
                model,
                battery.getLevel(),
                currentSim
        );
    }
}