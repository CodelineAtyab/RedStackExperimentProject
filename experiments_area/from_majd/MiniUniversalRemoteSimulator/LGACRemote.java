import java.util.Scanner;

public class LGACRemote extends RemoteCover  {
    
    public LGACRemote(){

System.out.println("==== LG AC Remote ====\n\n\n\n");


    }


    @Override
    public String getInfoFromScreen() {
        return "Channel #: [%d] Volume %%:[%d]".formatted(channelCounter<0?0:channelCounter,55);

    }

    @Override
    public Boolean turnon() {
togglePower();
        return true;
    }


    @Override
    public Boolean turnoff() {
      togglePower();
        return true;
    }


    @Override
    public int turnCounterDown() {
        // TODO Auto-generated method stub
        if(channelCounter<0)
            return channelCounter=0;
        else
        return --channelCounter;
    }

@Override
public int turnCounterUp() {
            if(channelCounter<0)
            return channelCounter=0;
        else
    return ++channelCounter;
}




 private Boolean togglePower(){
        System.out.println("Check the existing state");
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
        private int channelCounter=0;

}


