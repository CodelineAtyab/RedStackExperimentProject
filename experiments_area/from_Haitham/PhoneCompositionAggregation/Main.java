public class Main {
    public static void main(String[] args) {
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
        /*
        Battery is a composition relationship because if we distroy smartphone class the battery class will disappear.
        SimCard is a aggregation relationship because it wont disappear when we destroy smartphone class.
         */
    }
}