public class Warmup1 {

// warmup 1: hasTeen
public static boolean hasTeen(int a, int b, int c) {
  return ((a>=13 && a<=19) || (b>=13 && b<=19) || (c>=13 && c<=19));
}

//warmup1: sumDouble
public static int sumDouble(int a, int b) {

return (a==b)? (a+b)*2: a+b;
  
}


//warmup1:startHi
public static boolean startHi(String str) {
  
boolean CheckStartWithHi=false;
  if(str.length()>=2)
CheckStartWithHi=str.substring(0,2).equals("hi");

return CheckStartWithHi;
  
}


//warmup1: missingChar
    public static String missingChar(String str, int n) {
  
  String sentenceWithoutSpecifiedChar=str.substring(0,n)+str.substring(n+1);
  
  return sentenceWithoutSpecifiedChar;
}

}
