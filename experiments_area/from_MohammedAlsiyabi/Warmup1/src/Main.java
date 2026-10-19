public class Main {
    public static void main(String[] args) {
        System.out.println(sleepIn(false, false));
        System.out.println(sleepIn(true, false));
        System.out.println(sleepIn(true, true));
    }
//    sleepIn
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }

        return false;
    }

//    monkeyTrouble
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile) {
            return true;
        }
        if (!aSmile && !bSmile) {
            return true;
        }
        return false;
    }


//    sumDouble
    public int sumDouble(int a, int b) {

        int sum = a + b;

        if (a == b) {
            sum = sum * 2;
        }

        return sum;
    }

    
//    diff21
    public int diff21(int n) {
        if (n <= 21) {
            return 21 - n;
        } else {
            return (n - 21) * 2;
        }
    }



}