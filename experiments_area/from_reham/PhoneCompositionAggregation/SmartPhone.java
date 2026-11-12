public class SmartPhone {
    private String model;
    private Battery battery;
    private SimCard simcard;

    public SmartPhone(String model){
        this.model=model;
        this.battery=new Battery();
       
    }

    public void insertSim(SimCard simCard){
        this.simcard=simCard;
    }

    public void removeSim(){
        this.simcard=null;
    }

    public void makeCall(int minutes){
        if(this.simcard==null){
            System.out.println(model+": Has no simCard");
            return;
        }else{
            int BatteryDrain= minutes*2;
            if(battery.getLevel()>BatteryDrain){
                this.battery.drain(BatteryDrain);
                System.out.println(this.model+" called for "+minutes+" minutes using the number: "+this.simcard.getNumber()+" | Battery level : "+this.battery.getLevel()+"%");
            }else{
                System.out.println(this.model+" Battery level: "+this.battery.getLevel()+"% you can not make the call, Battry is low. ");
            }
        }
    }

    public void printStatus(){
        System.out.println(this.model+" | Battery: "+this.battery.getLevel()+"% | SIM: "+ (this.simcard != null ? this.simcard.getNumber() : "none"));
    }
    
}
