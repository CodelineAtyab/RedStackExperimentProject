public class Battery {
    private int level = 100;

    // Package-private constructor
    Battery() {
        this.level = 100;
    }

    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        this.level -= amount;
        if (this.level < 0) {
            this.level = 0;
        }
    }
}