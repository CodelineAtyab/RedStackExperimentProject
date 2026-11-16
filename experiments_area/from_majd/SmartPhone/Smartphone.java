public class Smartphone {

    public String model;
    private Battery battery;
    private SimCard simCard;

    public Smartphone(String model){

        battery=new Battery();
        this.model=model;
    }

    public void insertSim(SimCard simCard){

        this.simCard=simCard;
    }


    public void removeSim(){

         this.simCard=null;
    }

    public void makeCall(int minutes){

        if(simCard==null)
            System.out.println(model+": no SIM card");

        else {
            battery.drain(minutes * 2);
            System.out.printf("%s called for %d min using %s, battery %d%%\n",model,minutes, simCard.getNumber(),battery.getLevel());
        }

    }


    public void printStatus(){
        System.out.printf("%s | Battery: %d%% | SIM: %s\n",model, battery.getLevel(),(simCard!=null? simCard.getNumber():"none"));
    }






}