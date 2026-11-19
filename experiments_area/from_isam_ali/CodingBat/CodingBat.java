public class CodingBat {
  public static int diff21(int n) {
    if (n <= 21 ) {
      return 21-n;
    }
    return (n - 21)*2;
  }

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    return aSmile == bSmile;
  }

  public boolean parrotTrouble(boolean talking, int hour) {
    if (talking && (hour < 7 || hour > 20)) {
      return true;
    }
    return false;
  }

  public boolean sleepIn(boolean weekday, boolean vacation) {
    if (!weekday || vacation) {
      return true;
    }
    return false;
  }

  public int sumDouble(int a, int b) {
    int sum = a+b;
    if (a == b){
      return sum*2;
    }
    return sum;
  }

  public boolean makes10(int a, int b) {
    int sum = a+b;
    if (a == 10 || b == 10){
      return true;
    }
    if (sum == 10) {
      return true;
    }
    return false;
  }
}