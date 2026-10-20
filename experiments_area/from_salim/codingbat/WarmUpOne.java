class WarmUpOne {
    public static void main(String[] args) {
        System.out.println("Team Red Stack !!!");
        System.out.println(WarmUpOne.sleepIn(true, false));
        System.out.println(WarmUpOne.monkeyTrouble(true, false));
        System.out.println(WarmUpOne.sumDouble(2, 2));
        System.out.println(WarmUpOne.diff21(2));
        System.out.println(WarmUpOne.parrotTrouble(true, 8));
        System.out.println(WarmUpOne.makes10(9, 1));
    }
    
    //task1
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation){
        return true;}
        return false;
    }

    //task2
    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile || !aSmile && !bSmile ) return true;
  
        return false;
    }

    //task3
    public static int sumDouble(int a, int b) {
        if (a==b) return (2*(a+b));
  
        return (a+b);
    }

    //task4
    public static int diff21(int n) {
    if (n > 21) return (2*(Math.abs(n-21)));
  
    return Math.abs(n-21);
    }

    //task5
    public static boolean parrotTrouble(boolean talking, int hour) {
    if (talking && (hour>20 || hour<7)) return true;
  
    return false;
    }

    //task6
    public static boolean makes10(int a, int b) {
        if ( a==10 || b==10 || (a+b)==10) return true;
    
    return false;
    }
}
