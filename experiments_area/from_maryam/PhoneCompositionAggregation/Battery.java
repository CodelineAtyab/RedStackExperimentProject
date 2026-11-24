public class Battery {

    // store the battery start from 100%
    private int level =100;

    //constructor
    Battery(){

    }

    public int getLevel(){
        return level;
    }

    public void drain(int amount){

        level = level- amount;

        // here to keep the battery level from 100% and  below 0.
        if (level < 0){
            level=0;
        }
    }
}
