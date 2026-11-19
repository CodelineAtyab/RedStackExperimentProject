
public class Warmup {

    public static void main(String[] args) {
        Warmup warmup = new Warmup();

        System.out.println(warmup.sleepIn(false, false));
        System.out.println(warmup.monkeyTrouble(true, true));
        System.out.println(warmup.sumDouble(2, 2));
        System.out.println(warmup.diff21(25));
        System.out.println(warmup.parrotTrouble(true, 6));
        System.out.println(warmup.makes10(5, 5));
        System.out.println(warmup.nearHundred(105));
    }


    //sleepIn
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        } else {
            return false;
        }
    }
    //monkeyTrouble
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile == bSmile) {
            return true;
        } else {
            return false;
        }
    }
    //sumDouble
    public int sumDouble(int a, int b) {
        int sum = a + b;
        if (a == b) {
            return (a + b) * 2;
        } else {
            return a + b;
        }
    }
    //diff21
    public int diff21(int n) {
        if (n <= 21) {
            return 21 - n;
        } else {
            return (n - 21) * 2;
        }
    }
    //parrotTrouble
    public boolean parrotTrouble(boolean talking, int hour) {
        if (talking && (hour < 7 || hour > 20)) {
            return true;
        } else {
            return false;
        }
    }
    //makes10
    public boolean makes10(int a, int b) {
        if (a == 10 || b == 10 || a + b == 10) {
            return true;
        } else {
            return false;
        }
    }

    //nearHundred
    public boolean nearHundred(int n) {
        return Math.abs(100 - n) <= 10
                || Math.abs(200 - n) <= 10;
    }
}
