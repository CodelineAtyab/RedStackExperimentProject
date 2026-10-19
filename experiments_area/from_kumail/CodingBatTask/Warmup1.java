
public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 W1 = new Warmup1();

        System.out.println(W1.sleepIn(false, false));

    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }


}
