public class Main {
    public static void main(String[] args) {
        // Composition: Smartphone creates and owns its Battery (new Battery() in
        // its constructor). The battery cannot be created outside the package,
        // is never shared, and lives and dies with its phone.
        //
        // Aggregation: Main creates the SimCard and passes the same object to
        // different phones. A phone only holds a reference to it, so removing
        // the SIM from one phone does not destroy it and it can move to another.
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
