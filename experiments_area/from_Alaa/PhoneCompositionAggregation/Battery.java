public class Battery{

    private int level; //battery level starts at 100%

    Battery() { //package-private constructor to prevent direct instantiation from outside the class
        this.level = 100; //initialize battery level to 100%
    }
       

    public void drain(int amount){
        if (this.level - amount >= 0){ // check so it does not go below 0
            this.level -= amount;
        } else {
            this.level = 0;
        }
    }


    public int getLevel(){
        return this.level;
    }

}