public class Warmup1 {
    public static void main(String[] args) {


    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
    if (weekday==false || weekday==true && vacation==true){
    return true;
      }
    return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if (!(aSmile ^ bSmile)){
    return true;
    }
    return false;
}
   
    
    public int sumDouble(int a, int b) {
    int sum = a + b;
    if (a == b) {
      sum = sum * 2;
    }
    return sum;
}
   
   public int diff21(int n) {
    if (n <= 21) {
      return 21 - n;
     } else {
       return (n - 21) * 2;
     }
}

   public boolean parrotTrouble(boolean talking, int hour) {
  return (talking && (hour < 7 || hour > 20));
}



}