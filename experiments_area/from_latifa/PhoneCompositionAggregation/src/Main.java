public class Main {

    public static void main(String[] args) {

        SimCard sim = new SimCard("99112233");
        Smartphone phone1 = new Smartphone("PhoneA");
        Smartphone phone2 = new Smartphone("PhoneB");

        // Battery is composition because each phone creates its own battery.
        // SIM is aggregation because it is created outside and can be shared.

        phone1.insertSim(sim);
        phone1.makeCall(10);
        phone1.printStatus();
        phone1.removeSim();
        phone1.makeCall(3);
        phone2.insertSim(sim);
        phone2.makeCall(5);
        phone2.printStatus();
        phone1.printStatus();
        System.out.println("SIM still exists: " + sim.getNumber());
    }
}