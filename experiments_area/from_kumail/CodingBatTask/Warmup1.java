
public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 W1 = new Warmup1();

        System.out.println(W1.sleepIn(false, false));
        System.out.println(W1.monkeyTrouble(true, true));
        System.out.println(W1.sumDouble(2, 7));
        System.out.println(W1.diff21(27));
        System.out.println(W1.parrotTrouble(true, 9));
        System.out.println(W1.makes10(8, 9));
        System.out.println(W1.nearHundred(105));
        System.out.println(W1.posNeg(-1, 1, false));
        System.out.println(W1.makes10(5, 9));



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

    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }
    public boolean nearHundred(int n) {
        return Math.abs(100 - n) <= 10
                || Math.abs(200 - n) <= 10;
    }
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return a < 0 && b < 0;
        } else {
            return (a < 0 && b > 0)
                    || (a > 0 && b < 0);
        }
    }






}
