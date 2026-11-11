public class Battery {
    private int level;

    Battery(){
        this.level = 100;
    }

    public void drain(int amount){
        this.level -= amount;
        if(this.level < 0){
            this.level = 0;
        }
    }

    public int getLevel() {
        return level;
    }
}