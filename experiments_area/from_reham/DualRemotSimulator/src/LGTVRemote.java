public class LGTVRemote extends RemoteCover{

    private boolean PowerState=false;
    private int channel=1;
    
    //Display information
    @Override 
    public String getInfoFromScreen(){return "Power: %-3s | Channel: %d".formatted(PowerState ? "ON" : "OFF", channel);} 

    @Override 
    public void turnOn(){
        System.out.println("Turning on ...");
        PowerState=true;
    } 
    
    @Override 
    public void turnOff(){
        System.out.println("Turning off ...");
        PowerState=false;
    }
    
    @Override 
    public void turnCounterUp(){
        channel++;
        System.out.println(getInfoFromScreen());
    }
    
    @Override  
    public void turnCounterDown(){
        if(channel>1){
            channel--;
        }System.out.println(getInfoFromScreen());
    }
   
    @Override 
    public void placeButtons(){
        System.out.println("=== LG TV REMOTE ===");
        System.out.println("[Power]     [CH+]     [CH-]");
    } //Place Buttons 
            
    
}
