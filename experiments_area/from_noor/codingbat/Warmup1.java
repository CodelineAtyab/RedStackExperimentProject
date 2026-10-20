public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 w = new Warmup1();
        System.out.println(w.sleepIn(false, false));
              System.out.println(diff21(19));

      
    }


    //q1
    //The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. 
    // We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
    public  boolean sleepIn(boolean weekday, boolean vacation) {
    return !weekday || vacation;
    }
 
    //q2
    //Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
   public static int diff21(int n) {
  if (n<=21){
    return 21-n;
  }else{
  return (n-21)*2;
  }
}



}