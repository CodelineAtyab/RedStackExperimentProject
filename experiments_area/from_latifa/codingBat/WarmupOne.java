public class WarmupOne{
	public static void main(String[] args){
		System.out.println(WarmupOne.sleepIn(true,true));
		System.out.println(WarmupOne.monkeyTrouble(true,false));
	}
	//sleepIn
	public static boolean sleepIn(boolean weekday, boolean vacation) {
  if((!weekday && !vacation) ||(!weekday && vacation) || (weekday && vacation)){
    return true;
  }
  else{
    return false;
  }
}
	//monkeyTrouble
	public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
  if((aSmile && bSmile) || (!aSmile && !bSmile)){
    return true;
  }else{
    return false;
  }
}
}