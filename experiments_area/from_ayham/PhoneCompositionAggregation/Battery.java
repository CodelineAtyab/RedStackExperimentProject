public class Battery {
    private int level = 100;

    Battery(int level) {
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        level -= amount;
        if (level < 0) {
            level = 0;
        }
    }


}
