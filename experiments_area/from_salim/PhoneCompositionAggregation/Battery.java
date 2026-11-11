public class Battery {
    Battery() {
    }

    public void drain(int amount) {
        level = Math.max(0, level - amount);
    }

    public int getLevel() {
        return level;
    }

    private int level = 100;
}