public class LGACRemote extends RemoteCover{
   
    private boolean PowerState=false;
    private int temperature=24;
    
    //Display information
    @Override 
    public String getInfoFromScreen(){return "Power: %-3s | temperature: %d".formatted(PowerState ? "ON" : "OFF", temperature);} 

    @Override 
    public void turnOn(){
        System.out.println("Turning AC on  ...");
        PowerState=true;
    } 
    
    @Override 
    public void turnOff(){
        System.out.println("Turning AC off ...");
        PowerState=false;
    }
    
    @Override 
    public void turnCounterUp(){
        temperature++;
        System.out.println(getInfoFromScreen());
    }
    
    @Override  
    public void turnCounterDown(){
        temperature--;
        System.out.println(getInfoFromScreen());
    }
   
    @Override 
    public void placeButtons(){
        System.out.println("=== LG AC REMOTE ===");
        System.out.println("[Power]     [TEMP+]     [TEMP-]");
    } //Place Buttons 
        
}
