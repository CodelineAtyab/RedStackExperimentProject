package Warmup1;

public class sleepIn {


    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        sleepIn test = new sleepIn();
        System.out.println(test.sleepIn(false, false));
    }}
