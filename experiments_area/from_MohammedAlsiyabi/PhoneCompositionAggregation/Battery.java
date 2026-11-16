public class Battery {
    private int level;

    Battery() {
        level = 100;
    }

    public void drain(int amount) {
        level = level - amount;
        if (level < 0) {
            level = 0;
        }
    }

    public int getLevel() {
        return level;
    }
}