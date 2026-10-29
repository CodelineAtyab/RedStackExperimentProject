public class Warmup1 {
    public static void main(String[] args) {
        Warmup1 w = new Warmup1();
        System.out.println(w.sleepIn(false, false));
              System.out.println(diff21(19));
              System.out.println(nearHundred(95));
              System.out.println(missingChar("kitten", 1));
              System.out.println(backAround("cat"));
              System.out.println(w.startHi("hi there"));
              System.out.println(w.hasTeen(13, 15, 17));

      
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


//q3
//Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.
public static boolean nearHundred(int n){
  return (Math.abs(100-n)<=10)||(Math.abs(200-n)<=10);
}


//q4
//Given a non-empty string and an int n, return a new string where the char at index n has been removed. 
// The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).
public static String missingChar(String str, int n) {
   return str.substring(0, n) + str.substring(n + 1);

}

//q5
//Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.
public static String backAround(String str) {
  String last = str.substring(str.length() - 1);
  return last + str + last;
}

//q6
//Given a string, return true if the string starts with "hi" and false otherwise.
public boolean startHi(String str) {
   if (str.length() >= 2 && str.substring(0, 2).equals("hi")) {
        return true;
    } else {
        return false;
    }
}


//q7
//We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values, return true if 1 or more of them are teen.
public boolean hasTeen(int a, int b, int c) {
     if ((a >= 13 && a <= 19) ||
        (b >= 13 && b <= 19) ||
        (c >= 13 && c <= 19)) {
        return true;
    } else {
        return false;
    }
}











}