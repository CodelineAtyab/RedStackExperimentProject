public class Battery {

    private int level = 100;

    Battery() {
    }

    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        if (amount > 0) {
            if (amount >= level) {
                level = 0;
            } else {
                level = level - amount;
            }
        }
    }
}