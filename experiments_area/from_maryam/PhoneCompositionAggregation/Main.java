public class Main {
    public static void main(String[] args) {


        // create the sim card
        SimCard sim = new SimCard("99112233");


        // create tow phone number and each one have diff battery
        Smartphone phone1 = new Smartphone("PhoneA");
        Smartphone phone2 = new Smartphone("PhoneB");


        phone1.insertSim(sim);

        phone1.makeCall(10);
        phone1.printStatus(); // Add this

        phone1.removeSim();

        phone1.makeCall(3);

        phone2.insertSim(sim);

        phone2.makeCall(5);
        phone2.printStatus(); // Add this

        phone1.printStatus();

        System.out.println("SIM still exists: " + sim.getNumber());


    }}

//  so in this task:
// 1. Composition>>  The smartphone creates its own battery.
// 2. Aggregation>>  The sim  card is created outside the smartphone
// 3. and can be shared between diff phones.
