class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello!!");
        System.out.println(sub(10, 3));
        System.out.println(diff21(30));
        System.out.println(sleepIn(true, false));
        System.out.println(monkeyTrouble(true, true));
        System.out.println(sumDouble(2, 2));
        System.out.println(parrotTrouble(true, 6));
        System.out.println(makes10(7, 3));
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int diff21(int n) {
        if (n <= 21) {
            return 21 - n;
        } else {
            return (n - 21) * 2;
        }
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }

    public static int sumDouble(int a, int b) {
        int sum = a + b;
        if (a == b) {
            return sum * 2;
        }
        return sum;
    }

    public static boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }

    public static boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }
}
