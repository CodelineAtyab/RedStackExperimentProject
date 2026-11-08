public class WarmUpOne {
    /*
     * Given three int values, a b c, return the largest.
     * 
     * intMax(1, 2, 3) → 3
     * intMax(1, 3, 2) → 3
     * intMax(3, 2, 1) → 3
     * 
     */

    public int intMax(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    /*
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
     * Given 2 int values, return true if one or the other is teen, but not both.
     * 
     * loneTeen(13, 99) → true
     * loneTeen(21, 19) → true
     * loneTeen(13, 13) → false
     * 
     */

    public boolean loneTeen(int a, int b) {
        if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19)) {

            if ((a >= 13 && a <= 19) && (b >= 13 && b <= 19)) {
                return false;
            }

            return true;
        }

        return false;
    }

    /*
     * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate
     * if each is smiling. We are in trouble if they are both smiling or if neither
     * of them is smiling. Return true if we are in trouble.
     * 
     * monkeyTrouble(true, true) → true
     * monkeyTrouble(false, false) → true
     * monkeyTrouble(true, false) → false
     * 
     */

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile) {
            return true;
        } else if (!aSmile && !bSmile) {
            return true;
        }
        return false;
    }

    /*
     * Given 2 int values, return true if one is negative and one is positive.
     * Except if the parameter "negative" is true, then return true only if both are
     * negative.
     * 
     * posNeg(1, -1, false) → true
     * posNeg(-1, 1, false) → true
     * posNeg(-4, -5, true) → true
     * 
     */

    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            if (a < 0 && b < 0) {
                return true;
            }
        } else {
            if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Given a string, return true if the string starts with "hi" and false
     * otherwise.
     * 
     * startHi("hi there") → true
     * startHi("hi") → true
     * startHi("hello hi") → false
     */

    public boolean startHi(String str) {
        if (str.startsWith("hi")) {
            return true;
        }
        return false;
    }

    /*
     * Given a string, return a string made of the first 2 chars (if present),
     * however include first char only if it is 'o' and include the second only if
     * it is 'z', so "ozymandias" yields "oz".
     * 
     * startOz("ozymandias") → "oz"
     * startOz("bzoo") → "z"
     * startOz("oxx") → "o"
     */

    public String startOz(String str) {

        String result = "";

        if (str.length() >= 1 && str.charAt(0) == 'o') {
            result += 'o';
        }

        if (str.length() >= 2 && str.charAt(1) == 'z') {
            result += 'z';
        }

        return result;

    }

    /*
     * Given a string, return a new string where the first and last chars have been
     * exchanged.
     * 
     * frontBack("code") → "eodc"
     * frontBack("a") → "a"
     * frontBack("ab") → "ba"
     */

    public String frontBack(String str) {

        if (str.length() <= 1) {
            return str;
        }

        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);

        String middle = str.substring(1, str.length() - 1);

        return last + middle + first;

    }
}
