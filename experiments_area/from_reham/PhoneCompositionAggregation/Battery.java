public class Battery {
    private int level;
    Battery(){
        this.level=100;
    }

    public int getLevel() {
        return this.level;
    }

    public void drain (int amount){
        if (this.level>0){
            this.level=this.level-amount;
        }else{
            this.level=0;
        }
    }


}
