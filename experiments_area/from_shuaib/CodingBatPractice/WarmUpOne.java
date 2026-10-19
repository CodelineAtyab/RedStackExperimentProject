public class WarmUpOne {
    /*
     * Given three int values, a b c, return the largest.
      
      intMax(1, 2, 3) → 3
      intMax(1, 3, 2) → 3
      intMax(3, 2, 1) → 3
      
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
    We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values, return true if one or the other is teen, but not both.


    loneTeen(13, 99) → true
    loneTeen(21, 19) → true
    loneTeen(13, 13) → false

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

}
