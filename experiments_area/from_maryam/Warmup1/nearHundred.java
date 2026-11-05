package Warmup1;

public class nearHundred {

    public boolean nearHundred(int n) {
        return (Math.abs(100 - n) <= 10 ||
                Math.abs(200 - n) <= 10);
    }


    public static void main(String[] args) {
        nearHundred obj = new nearHundred();

        System.out.println(obj.nearHundred(93));
        System.out.println(obj.nearHundred(90));
        System.out.println(obj.nearHundred(89));
        System.out.println(obj.nearHundred(110));
        System.out.println(obj.nearHundred(110));
        System.out.println(obj.nearHundred(200));
    }
}