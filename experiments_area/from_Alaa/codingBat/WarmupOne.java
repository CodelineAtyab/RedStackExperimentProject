public class WarmupOne {
  public static void main(String[] args) {
  System.out.println(WarmupOne.sleepIn(false, true));

	System.out.println(WarmupOne.monkeyTrouble(true, false));

	System.out.println(WarmupOne.sumDouble(3,2));

	System.out.println(WarmupOne.diff21(19));

	System.out.println(WarmupOne.parrotTrouble(true , 7 ));

	System.out.println(WarmupOne.makes10(9,10));
  
	System.out.println(WarmupOne.nearHundred(100));

	System.out.println(WarmupOne.everyNth("Miracle", 2));

  System.out.println(WarmupOne.endUp("Hello"));
  System.out.println(WarmupOne.endUp("Hi"));

  System.out.println(WarmupOne.lastDigit(7,17));

  System.out.println(WarmupOne.stringE("Hello"));
  System.out.println(WarmupOne.stringE("Heelle"));

  System.out.println(WarmupOne.max1020(11,19));
  System.out.println(WarmupOne.max1020(9,21));
	
  System.out.println(WarmupOne.max3050(30,40));
  System.out.println(WarmupOne.max3050(20,50));



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
 public static boolean makes10(int a, int b) {
  if ((a==10 || b==10) || (a+b==10)){
    return true;
  }
  else{
    return false;
  }
}

//nearHundred
public static boolean nearHundred(int n) {
  if (Math.abs(100-n)==10 || Math.abs(200-n)==10){
    return true;
  }
  else{
    return false;
  }
}

// everyNth
public static String everyNth(String str, int n) {
  String result="";
  for (int i=0; i<str.length(); i+=n){
    result+=str.charAt(i);
  }
  return result;
}

//endUp 
public static String endUp(String str) {
  if (str.length() < 3) {
    return str.toUpperCase();
  }
  else {
    String lastThree = str.substring(str.length() - 3);
    String firstPart = str.substring(0, str.length() - 3);
    return firstPart + lastThree.toUpperCase();
  }   
}

//lastDigit 
public static boolean lastDigit(int a, int b) {
  return (a % 10) == (b % 10); 
}

//stringE
public static boolean stringE(String str) {
  int count = 0;
  for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == 'e') {
      count++;
    }
  }
  return count<=3 && count>=1;
}

//max1020
public static int max1020(int a, int b) {
  if ((a >= 10 && a <= 20) || (b >= 10 && b <= 20)) {
    return Math.max(a, b);
  } 
  else {
    return 0;
  }
}

//max3050
public static int max3050(int a, int b) {
  if ((a >= 30 && a <= 40) || (b >= 30 && b <= 40)) {
    return Math.max(a, b);
  } 
  else {
    return 0;
  }
}



}