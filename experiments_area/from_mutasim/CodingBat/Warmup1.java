class Warmup1 {
    public static void main(String[] args) {
        Warmup1 warmUp = new Warmup1();

        System.out.println(warmUp.sleepIn(true, true));
        System.out.println(warmUp.monkeyTrouble(true, true));
        System.out.println(warmUp.sumDouble(2, 2));
        System.out.println(warmUp.diff21(10));
        System.out.println(warmUp.parrotTrouble(true, 7));
        System.out.println(warmUp.makes10(9,9));
        System.out.println(warmUp.nearHundred(95));
        System.out.println(warmUp.posNeg(-2,-5, true));
        System.out.println(warmUp.notString("m"));
        System.out.println(warmUp.missingChar("MutasimX",7));
        System.out.println(warmUp.frontBack("Mutasim"));
        System.out.println(warmUp.front3("Mutasim"));
        System.out.println(warmUp.backAround("Mutasim"));
        System.out.println(warmUp.or35(25));
        System.out.println(warmUp.front22("Mutasim"));
        System.out.println(warmUp.startHi("Hi Dear"));
        System.out.println(warmUp.icyHot(5,120));
        System.out.println(warmUp.in1020(25,95));
        System.out.println(warmUp.hasTeen(12,18,22));
        System.out.println(warmUp.loneTeen(15,18));
        System.out.println(warmUp.delDel("adellaptop"));
        System.out.println(warmUp.mixStart("mix snacks"));
        System.out.println(warmUp.startOz("oxyOman"));
        System.out.println(warmUp.intMax(1,3,5));
        System.out.println(warmUp.close10(9,5));
        System.out.println(warmUp.in3050(30,31));
        System.out.println(warmUp.max1020(19,11));
        System.out.println(warmUp.stringE("Hello"));
        System.out.println(warmUp.lastDigit(8,17));
        System.out.println(warmUp.endUp("HeLLO"));
        System.out.println(warmUp.everyNth("Mutasim",3));
    }

    // 1. SleepIn -------------------------
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }

    // 2. monkeyTrouble ------------------
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ( aSmile && bSmile) {
            return true;
        }
        if ( !aSmile && !bSmile) {
            return true;
        }
        return false;
    }

    // 3. sumDouble
    public int sumDouble(int a, int b) {
        int sum = a + b;

        if (a == b) {
            sum = sum * 2;
        }
        return sum;
    }

    // 4. diff21
    public int diff21(int n) {
        if ( n <= 21) {
            return 21 - n;
        }
        else {
            return (n-21)*2;
        }
    }

    // 5. parrotTrouble
    public boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour > 20));
    }

    // 6. makes10
    public boolean makes10(int a, int b) {
        if (a == 10 || b == 10 || a + b == 10) {
            return true;
        }
        return false;
    }

    // 7. nearHundred
    public boolean nearHundred(int n) {
        if ( (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10)) {
            return true;
        }
        return false;
    }

    // 8. posNeg
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        }
        else {
            return ((a < 0 && b > 0) || (a > 0 && b < 0));
        }
    }

    // 9. notString
    public String notString(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
            return str;
        }
        return "not " + str;
    }

    // 10. missingChar
    public String missingChar(String str, int n) {
        String front = str.substring(0, n);
        String back = str.substring(n+1, str.length());
        return front + back;
    }

    // 11. frontBack
    public String frontBack(String str) {
        if (str.length() <= 1) return str;

        String mid = str.substring(1, str.length()-1);
        return str.charAt(str.length()-1) + mid + str.charAt(0);
    }

    // 12. front3
    public String front3(String str) {
        String front;

        if (str.length() >= 3) {
            front = str.substring(0, 3);
        }
        else {
            front = str;
        }
        return front + front + front;
    }

    // 13. backAround
    public String backAround(String str) {
        String last = str.substring(str.length() - 1);
        return last + str + last;
    }

    // 14. or35
    public boolean or35(int n) {
        return (n % 3 == 0) || (n % 5 == 0);
    }

    // 15. front22
    public String front22(String str) {
        int take = 2;

        if (take > str.length()) {
            take = str.length();
        }

        String front = str.substring(0, take);
        return front + str + front;
    }

    // 16. startHi
    public boolean startHi(String str) {
        if (str.length() < 2) return false;

        String firstTwo = str.substring(0, 2);

        if (firstTwo.equals("hi")) {
            return true;
        } else {
            return false;
        }
    }

    // 17. icyHot
    public boolean icyHot(int temp1, int temp2) {
        if ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    // 18. in1020
    public boolean in1020(int a, int b) {
        return ((a >= 10 && a <= 20) || (b >= 10 && b <= 20));
    }

    // 19. hasTeen
    public boolean hasTeen(int a, int b, int c) {
        return (a>=13 && a<=19) ||
                (b>=13 && b<=19) ||
                (c>=13 && c<=19);
    }

    // 20. loneTeen
    public boolean loneTeen(int a, int b) {
        boolean aTeen = (a >= 13 && a <= 19);
        boolean bTeen = (b >= 13 && b <= 19);

        return (aTeen && !bTeen) || (!aTeen && bTeen);
    }

    // 21. delDel
    public String delDel(String str) {
        if (str.length()>=4 && str.substring(1, 4).equals("del")) {
            return str.substring(0, 1) + str.substring(4);
        }
        return str;
    }

    // 22. mixStart
    public boolean mixStart(String str) {
        if (str.length() < 3) return false;

        String two = str.substring(1, 3);

        if (two.equals("ix")) {
            return true;
        } else {
            return false;
        }
    }

    // 23. startOz
    public String startOz(String str) {
        String result = "";

        if (str.length() >= 1 && str.charAt(0)=='o') {
            result = result + str.charAt(0);
        }

        if (str.length() >= 2 && str.charAt(1)=='z') {
            result = result + str.charAt(1);
        }

        return result;
    }

    // 24. intMax
    public int intMax(int a, int b, int c) {
        int max;

        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    // 25. close10
    public int close10(int a, int b) {
        int aDiff = Math.abs(a - 10);
        int bDiff = Math.abs(b - 10);

        if (aDiff < bDiff) {
            return a;
        }
        if (bDiff < aDiff) {
            return b;
        }
        return 0;
    }

    // 26. in3050
    public boolean in3050(int a, int b) {
        if (a >= 30 && a <= 40 && b >= 30 && b <= 40) {
            return true;
        }
        if (a >= 40 && a <= 50 && b >= 40 && b <= 50) {
            return true;
        }
        return false;
    }

    // 27. max1020
    public int max1020(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }

    // 28. stringE
    public boolean stringE(String str) {
        int count = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'e') count++;
            // alternately: str.substring(i, i+1).equals("e")
        }

        return (count >= 1 && count <= 3);
    }

    // 29. lastDigit
    public boolean lastDigit(int a, int b) {
        return(a % 10 == b % 10);
    }

    // 30. endUp
    public String endUp(String str) {
        if (str.length() <= 3) return str.toUpperCase();
        int cut = str.length() - 3;
        String front = str.substring(0, cut);
        String back  = str.substring(cut);  // this takes from cut to the end

        return front + back.toUpperCase();
    }

    // 31. everyNth
    public String everyNth(String str, int n) {
        String result = "";

        for (int i=0; i<str.length(); i = i + n) {
            result = result + str.charAt(i);
        }
        return result;
    }
}