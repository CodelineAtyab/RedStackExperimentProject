import java.util.Scanner;

public class LGACRemote extends RemoteCover  {
    
    public LGACRemote(Boolean displayText){

                this.displayText = displayText;

System.out.println("==== LG AC Remote ====");


    }


    @Override
    public String getInfoFromScreen() {
  if (displayText)
            return "Power: " + (tvPowerState ? "ON" : "OFF") + " | Channel: " + channelCounter;
        else
            return "Channel #: [%d] Volume %%:[%d]".formatted(channelCounter < 0 ? 0 : channelCounter, 55);
    }

    @Override
    public Boolean turnon() {
  if (displayText)
        System.out.println("Turning ON...");
        

        togglePower();
    

        return true;
    }


    @Override
    public Boolean turnoff() {
         if (displayText)
            System.out.println("Turning OFF...");
        togglePower();
        return true;
    }


    @Override
    public int turnCounterDown() {
          if (displayText) {
            System.out.println("Channel Down -> " + (--channelCounter));
            return channelCounter;
        }

        else
            return --channelCounter;
    }

@Override
public int turnCounterUp() {
      if (displayText) {
            System.out.println("Channel Up -> " + (++channelCounter));
            return channelCounter;

        } else
            return ++channelCounter;
}




 private Boolean togglePower(){
        // System.out.println("Check the existing state");
        if(!tvPowerState)
            tvPowerState=true;
        else
            tvPowerState=false;

        return tvPowerState;
    }



      @Override
    public void channelChanger(int inputValue) {
        


        if(inputValue==1)
            turnCounterUp();
        else if(inputValue==0)
            turnCounterDown();

        
    }

        private Boolean tvPowerState=false;
    private Boolean displayText = false;

    private int channelCounter = 1;
}


