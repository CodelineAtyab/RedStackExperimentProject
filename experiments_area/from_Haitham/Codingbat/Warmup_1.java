class Warmup_1{
    public static void main(String[] args) {

    }


    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if(!weekday  == true )
        {
            return true;

        }
        if(vacation == true )
        {
            return true;

        }
        return false;
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if(aSmile  == true && bSmile == true )
        {
            return true;

        }
        else if (!aSmile && !bSmile)
        {
            return true;
        }
        return false;
    }


    public static int sumDouble(int a, int b) {
        if (a != b)
        {
            int sum = a+b;
            return sum;
        }
        else if(a == b)
        {
            int sum = (a+b)*2;
            return sum;
        }
        return 0;
    }

    public static int diff21(int n) {
        if(n <=21){
            int sum = n-21;
            return Math.abs(sum);
        }
        else
        {
            int sum =n-21;
            int dbl = sum * 2;
            return Math.abs(dbl);
        }

    }

    public static boolean parrotTrouble(boolean talking, int hour) {
        if(talking == true && (hour <7 || hour >20))
        {
            return true;
        }
        return false;
    }

    public static boolean makes10(int a, int b) {
        if (a == 10 || b == 10 || a+b== 10)
        {
            return true;
        }
        return false;
    }

    public static boolean nearHundred(int n) {
        if((n <=110 && n >=90) || (n <=210 && n >=190) )
        {
            return true;
        }
        return false;
    }




















}