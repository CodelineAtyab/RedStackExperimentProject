public class  WarmupOne_Solution{
  public static void main(String[] args) {
    System.out.println("Hello World");
	System.out.println(WarmupOne_Solution.sleepIn(false,false));
	System.out.println(WarmupOne_Solution.monkeyTrouble(true ,true));
	System.out.println(WarmupOne_Solution.sumDouble(1,2));
	System.out.println(WarmupOne_Solution.diff21(19));
	System.out.println(WarmupOne_Solution.parrotTrouble(true,6));
  }
  
  public static boolean sleepIn(boolean weekday, boolean vacation) 
{
 if (!weekday || vacation ) {
   return true;
 }
 return false; 

}
public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
  if (aSmile && bSmile){
    return true;
  }
  if(!aSmile && !bSmile){
    return true;
  }
  return false;
}
public static int sumDouble(int a, int b) {
  // store the sum in a local variable
  int sum = a + b;
  // Double it if a and b are the same
  if(a == b) {
    sum = sum * 2;
  }
  return sum ;
}
public static int diff21(int n) {
  if (n <= 21){
    return 21 - n;
  }else{
    return (n - 21)*2;
  }
}
public static boolean parrotTrouble(boolean talking, int hour) {
  return (talking && (hour <7 || hour >20));
}}
