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

    public static boolean posNeg(int a, int b, boolean negative) {
        if(a<0 && b<0 && negative == true)
        {
            return true;
        }
        else if((a<0 && b>=0 && negative == false)||(b<0 && a>=0 && negative == false) )
        {
            return true;
        }
        return false;
    }

    public static String notString(String str) {
        if(str.length() >=3 && str.substring(0,3).equals("not"))
        {
            return str;
        }


        return "not " + str;
    }


    public static String missingChar(String str, int n) {
        String front = str.substring(0,n);
        String back = str.substring(n+1,str.length());
        return front+back;
    }


    public static String frontBack(String str) {
        if(str.length() >1){

            String mid =str.substring(1,str.length()-1) ;
            return str.charAt(str.length()-1) + mid + str.charAt(0);
        }
        return str;
    }



    public String front3(String str) {
        if (str.length()>=3)
        {
            String neew = str.substring(0,3);
            return neew+neew+neew;
        }
        else if(str.length()== 2)
        {
            String neew = str.substring(0,2);
            return neew+neew+neew;
        }
        else if(str.length()== 1){
            String neew = str.substring(0,1);
            return neew+neew+neew;
        }
        else
        {
            return "";
        }
    }


    public static String backAround(String str) {
        String neew = str.substring(str.length()-1);
        return neew+str+neew;
    }



    public static boolean or35(int n) {
        return (n % 3 == 0) || (n % 5 == 0);
    }


    public static String front22(String str) {
        if (str.length()>=2 )
        {
            String neew = str.substring(0,2);
            return neew + str + neew;
        }
        else if(str.length() == 1 )
        {
            String neew = str.substring(0,1);
            return neew + str + neew;
        }
        return str;
    }


    public static boolean startHi(String str) {
        if (str.length() <2)
        {
            return false;
        }
        String neew = str.substring(0, 2);
        if (neew.equals("hi"))
        {
            return true;
        }
        return false;
    }



    public static boolean icyHot(int temp1, int temp2) {
        if ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0))
        {
            return true;
        }
        return false;
    }


    public static in1020(int a, int b) {
        if ((a >= 10 && a <= 20) || (b >= 10 && b <= 20))
        {
            return true;
        }
        return false;
    }

    public static boolean hasTeen(int a, int b, int c) {
        if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19)) {
            return true;
        }
        return false;
    }

    public static boolean loneTeen(int a, int b) {
        if (((a >= 13 && a <= 19) && !(b >= 13 && b <= 19)) || ((b >= 13 && b <= 19) && !(a >= 13 && a <= 19)) )
        {
            return true;
        }
        return false;
    }

    public static String delDel(String str) {
        if (str.length() >=4 && str.substring(1,4).equals("del"))
        {
            String neew = str.substring(0,1)+str.substring(4);
            return neew ;

        }
        return str;

    }

    public static boolean mixStart(String str) {
        if(str.length() <=2)
        {
            return false;
        }
        if(str.substring(1,3).equals("ix"))
        {
            return true;
        }
        return false;
    }



    public static String startOz(String str) {
        String neww = "";
        if (str.length() >= 1 && str.charAt(0)=='o')
        {
            neww = neww + str.charAt(0);
        }
        if (str.length() >= 2 && str.charAt(1)=='z')
        {
            neww = neww + str.charAt(1);
        }
        return neww;
    }









}