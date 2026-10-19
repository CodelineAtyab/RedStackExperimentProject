class WarmUp1{
	//Task 1
    public boolean sleepIn(boolean weekday, boolean vacation) {
      if (weekday && vacation){
        return true;
      }else if (!weekday && vacation){
        return true;
      }else if(!weekday&& !vacation){
        return true;
      }else{
        return false;
      }
    }
	
	//Task 2
	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
	  if( aSmile && bSmile){
		return true;
		
	  }else if (!aSmile && !bSmile){
		return true;
	  }else{
		return false;
	  }
	}

	
    public static void main(){
		WarmUp1 obj = new WarmUp1();
		//Task 1
		System.out.println("Task1-sleepIn");
		System.out.println(obj.sleepIn(true, false));
        System.out.println(obj.sleepIn(false, false));
        System.out.println(obj.sleepIn(false, true));
		//Task 2
		System.out.println("Task2-monkeyTrouble");
		System.out.println(obj.monkeyTrouble(true,true));
		System.out.println(obj.monkeyTrouble(false,false));
		System.out.println(obj.monkeyTrouble(true,false));
		

    }
}