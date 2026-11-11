import java.util.Scanner;

public class LGTVRemote extends RemoteCover {
    


    public LGTVRemote(){

System.out.println("==== LG TV Remote ====\n\n\n\n");

    }





    @Override
    public String getInfoFromScreen() {
        return "Channel #: [%d] Volume %%:[%d]".formatted(channelCounter<0?0:channelCounter,55);
    }

    @Override
    public int turnCounterDown() {
        return --channelCounter;
    }

    @Override
    public Boolean turnoff() {
     togglePower();
        return true ;
    }


    @Override
    public int turnCounterUp() {
        return ++channelCounter;
    }


    @Override
    public Boolean turnon() {
togglePower();
        return true ;
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
