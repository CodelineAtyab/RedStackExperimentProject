
public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 W1 = new Warmup1();

        System.out.println(W1.sleepIn(false, false));
        System.out.println(W1.monkeyTrouble(true, true));
        System.out.println(W1.sumDouble(2, 4));
        System.out.println(W1.diff21(27));
        System.out.println(W1.parrotTrouble(true, 9));



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
    public int sumDouble(int a, int b) {
        int s = a + b;
        if (a == b) {
            s = s * 2;
        }
        return s;
    }
    public int diff21(int n) {
        if (n <= 21) {
            return 21 - n;
        } else {
            return (n - 21) * 2;
        }
    }
    
    public boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }






}
