
public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 W1 = new Warmup1();

        System.out.println(W1.sleepIn(false, false));
        System.out.println(W1.monkeyTrouble(true, true));

    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile) {
            return true;
        }
        if (!aSmile && !bSmile) {
            return true;
        }
        return false;
    }



}
