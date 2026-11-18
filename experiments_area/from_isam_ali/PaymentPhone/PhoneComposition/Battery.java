class Battery {
    private int level = 100;

    Battery() {}

    int getLevel() {
        return level;
    }

    void drain(int amount) {
        level = Math.max(0, level - amount);
    }
}