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


//    parrotTrouble
    public boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour > 20));
    }


//    makes10
    public boolean makes10(int a, int b) {
        return (a == 10 || b == 10 || a+b == 10);
    }


//    nearHundred
    public boolean nearHundred(int n) {
        return ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10));
    }

//    posNeg
    public boolean posNeg(int a, int b, boolean negative) {
        if (a < 0 && b < 0 && negative) {
            return true;
        }
        else if ((a < 0 && b > 0 || a > 0 && b < 0) && !negative) {
            return true;
        }
        return false;
    }


//    notString
    public String notString(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
            return str;
        }
        return "not " + str;
    }

//    missingChar
    public String missingChar(String str, int n) {
        String front = str.substring(0, n);

        String back = str.substring(n+1, str.length());
        return front + back;
    }


}