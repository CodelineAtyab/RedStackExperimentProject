
public class Main {

    public static void main(String[] args) {

        // Create one SIM card (aggregation)
        // The SIM card is created outside the Smartphone.
        SimCard sim = new SimCard("99112233");

        // Create two smartphones (each creates its own battery)
        Smartphone phone1 = new Smartphone("PhoneA");
        Smartphone phone2 = new Smartphone("PhoneB");

        // Insert the SIM card into PhoneA
        phone1.insertSim(sim);

        // PhoneA makes a call for 10 minutes
        phone1.makeCall(10);

        // Display PhoneA status
        phone1.printStatus();

        // Remove the SIM card from PhoneA
        phone1.removeSim();

        // Try making a call without a SIM card
        phone1.makeCall(3);

        // Insert the SAME SIM card into PhoneB
        phone2.insertSim(sim);

        // PhoneB makes a call for 5 minutes
        phone2.makeCall(5);

        // Display PhoneB status
        phone2.printStatus();

        // Display PhoneA status again
        phone1.printStatus();

        // Prove that removing the SIM did not destroy the object
        System.out.println("SIM still exists: " + sim.getNumber());

        /*
         * Composition: Smartphone creates and owns its Battery.
         * Aggregation: SimCard is created outside Smartphone
         * and can be removed and reused by another phone.
         */
    }
}
