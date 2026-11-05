package Warmup1;

public class posNeg {


    public static void main(String[] args) {

        posNeg obj = new posNeg();
        System.out.println(obj.posNeg(-1, 1, false));

    }

    public boolean posNeg( int a, int b , boolean nagative)
    {
        if (nagative){
            return (a < 0 && b < 0 ==true);

        }
        else {
            return ((a < 0 && b < 0) || (a > 0 && b > 0));


        }

    }
}