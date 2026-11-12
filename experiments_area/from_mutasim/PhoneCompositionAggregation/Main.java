public class Main {
    public static void main(String[] args) {

        /*
         Composition: The Smartphone creates and owns its
         Battery, so the Battery belongs to that phone.

         Aggregation: The SimCard is created outside the
         Smartphone and can be moved between different phones.
         */

        SimCard sharedSim = new SimCard("99112233");

        Smartphone firstPhone = new Smartphone("PhoneA");
        Smartphone secondPhone = new Smartphone("PhoneB");

        firstPhone.insertSim(sharedSim);
        firstPhone.makeCall(10);
        firstPhone.printStatus();

        firstPhone.removeSim();
        firstPhone.makeCall(3);

        secondPhone.insertSim(sharedSim);
        secondPhone.makeCall(5);
        secondPhone.printStatus();

        firstPhone.printStatus();
        System.out.println("SIM still exists: " + sharedSim.getNumber());
    }
}