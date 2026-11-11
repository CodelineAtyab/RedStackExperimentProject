public class Battery {
    private int level;

    // Package-private: no public/private modifier
    Battery() {
        this.level = 100;
    }

    public void drain(int amount) {
        level = Math.max(0, level - amount);
    }

    public int getLevel() {
        return level;
    }
}
