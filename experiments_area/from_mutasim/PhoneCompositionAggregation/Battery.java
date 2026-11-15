
public class Battery {
    private int level = 100;

    Battery() {

    }

    public int getLevel() {
        return level;
    }

    public void drain(int powerUsed) {
        level -= powerUsed;

        if (level < 0) {
            level = 0;
        }
    }
}