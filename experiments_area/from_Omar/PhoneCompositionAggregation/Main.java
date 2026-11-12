public class Main {
    public static void main(String[] args) {
        // Relationship explanation comment required by criteria:
        /*
         * Composition vs Aggregation:
         * 1. Composition: Smartphone and Battery. The Smartphone creates and owns its Battery
         *    internally via 'new Battery()'. The Battery cannot exist independently of that specific phone.
         * 2. Aggregation: Smartphone and SimCard. The SimCard is created externally in Main and handed
         *    into the phone via insertSim(). It can be swapped out and moved to another phone freely,
         *    surviving the removal process.
         */

        SimCard sim = new SimCard("99112233");
        Smartphone phone1 = new Smartphone("PhoneA");
        Smartphone phone2 = new Smartphone("PhoneB");

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