public class Smartphone {


    private String model;
    private Battery battery;
    private SimCard simCard;


    //her to creates a smartphone with a new battery.
    public Smartphone(String model){

        this.model= model;
        this.battery= new Battery();

    }

    // to insert the sim in phone
    public void insertSim(SimCard simCard){

        this.simCard=simCard;
    }


    // to remove the sim from the phone
    public void removeSim(){

        this.simCard= null;
    }

    // to makes a call and reduces the battery level
    public void makeCall(int minutes){

        // use to checks if the phone has a SIM card.
        if (simCard==null){

            System.out.println(model + ": no SIM card");
            return;
        }

        // use it to reduces the battery level based on the call duration.
        battery.drain(minutes * 2);

        // print the call duration
        System.out.println(model + " called for " + minutes + " min using " + simCard.getNumber() + ", battery " + battery.getLevel() + "%");
    }

    // her to prints the phone model , battery level andsim card number.
    public void printStatus() {

        String number = "none";

        // her to get the sim card number if one is inserted.
        if (simCard != null) {
            number = simCard.getNumber();
        }

        //print
        System.out.println(model + " | Battery: " + battery.getLevel() + "% | SIM: " + number);
    }
}
