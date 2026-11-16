public class Battery {
    private int level = 100;

    Battery() {
        level = 100;
    }

    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        level = level - amount;

        if (level < 0) {
            level = 0;
        }
    }

}