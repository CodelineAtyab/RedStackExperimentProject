public class Warmup1 {

  // warmup 1: hasTeen
   static boolean hasTeen(int a, int b, int c) {
    return ((a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19));
  }

  // warmup1: sumDouble function
   static int sumDouble(int a, int b) {

    return (a == b) ? (a + b) * 2 : a + b;

  }

  // warmup1:startHi
  public static boolean startHi(String str) {

    boolean CheckStartWithHi = false;
    if (str.length() >= 2)
      CheckStartWithHi = str.substring(0, 2).equals("hi");

    return CheckStartWithHi;

  }

  // warmup1: missingChar
  public static String missingChar(String str, int n) {

    String sentenceWithoutSpecifiedChar = str.substring(0, n) + str.substring(n + 1);

    return sentenceWithoutSpecifiedChar;
  }

  // warmup1: diff21
  public static int diff21(int n) {
    if(n>21)
      return Math.abs((n-21)*2);
    else
      return Math.abs(n-21);
  }





// warmup 1: close10

 static int close10(int a, int b) {
  if(Math.abs(a-10)<Math.abs(b-10))
    return a;
  else if(Math.abs(b-10)<Math.abs(a-10))
    return b;

  return 0;

}



  public static void main(String[] args){

    System.out.println(hasTeen(1,2,3));
    System.out.println(sumDouble(2,3));
    System.out.println(startHi("Hillo"));
    System.out.println(missingChar("Hello",1));
    System.out.println(diff21(4));
    System.out.println(close10(10,3));

  }

}