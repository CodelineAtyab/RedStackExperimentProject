package PhoneCompositionAggregation;

public class Battery {

    private int level;

    Battery() {
        level = 100;
    }

    public int getLevel() {
        return level;
    }

    public void drain(int amount) {
        level = Math.max(0, level - amount);
    }
}
