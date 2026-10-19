public class WarmupOne {
  public static void main(String[] args) {
    System.out.println(WarmupOne.sleepIn(false, true));
	System.out.println(WarmupOne.monkeyTrouble(true, false));
	System.out.println(WarmupOne.sumDouble(3,2));
	System.out.println(WarmupOne.diff21(19));
	System.out.println(WarmupOne.parrotTrouble(true , 7 ));
	System.out.println(WarmupOne.makes10(9,10));
  }
  //sleepIn solution
  public static boolean sleepIn(boolean weekday, boolean vacation) {
  if (!weekday || vacation) {
    return true;
  }
  else {
    return false;
  }
}
 // monkeyTrouble solution
public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
  if  ((aSmile && bSmile) || (!aSmile && !bSmile)){
    return true;
    }
  else{
    return false;
  }
}

//Sum of 2 numbers
public static int sumDouble(int a, int b) {
  int sum = a+b;

  if (a==b){
    return 2*sum;
  }
  return sum;
}

//diff of 21
public static int diff21(int n) {

  if ( n<=21) {
    return 21-n;
  }
  else{
  return  (n-21)*2 ;}

}

//parrotTrouble
public static boolean parrotTrouble(boolean talking, int hour) {
  if(talking && (hour<7 || hour>20)){
    return true;
  }
  else{
    return false;
  }
}

//makes 10
 public boolean makes10(int a, int b) {
  if ((a==10 || b==10) || (a+b==10)){
    return true;
  }
  else{
    return false;
  }
}


}