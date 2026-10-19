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


}