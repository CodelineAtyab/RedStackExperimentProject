public class AlmuatsamWarmup {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile) {
            return true;
        }
        if (!aSmile && !bSmile) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        AlmuatsamWarmup warmup = new AlmuatsamWarmup();

        System.out.println(warmup.sleepIn(false, false));
        System.out.println(warmup.sleepIn(true, false));
        System.out.println(warmup.sleepIn(true, true));

        System.out.println(warmup.monkeyTrouble(true, true));
        System.out.println(warmup.monkeyTrouble(false, false));
        System.out.println(warmup.monkeyTrouble(true, false));



    }

}