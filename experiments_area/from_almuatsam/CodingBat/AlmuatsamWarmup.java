
public class AlmuatsamWarmup {

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
        int sum = a + b;

        if (a == b) {
            sum = sum * 2;
        }
        return sum;
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

    public static void main(String[] args) {
        AlmuatsamWarmup warmup = new AlmuatsamWarmup();

        System.out.println(warmup.sleepIn(false, false));
        System.out.println(warmup.monkeyTrouble(true, true));
        System.out.println(warmup.sumDouble(2, 2));
        System.out.println(warmup.diff21(25));
        System.out.println(warmup.parrotTrouble(true, 6));
    }
}
