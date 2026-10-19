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
	
	//Task 3
	public int sumDouble(int a, int b) {
	  if (a>b||a<b){
		return a+b;
	  }else{
		return ((a+b)*2);
	  }
	}
	
	//Task 4
	public int diff21(int n) {
	  if (n<21){
		return Math.abs(n-21);
	  }else{
		return (Math.abs(n-21)*2);
	  }
	}

	
    public static void main(){
		WarmUp1 obj = new WarmUp1();
		//Task 1
		System.out.println("Task1-sleepIn:");
		System.out.println(obj.sleepIn(true, false));
        System.out.println(obj.sleepIn(false, false));
        System.out.println(obj.sleepIn(false, true));
		//Task 2
		System.out.println("Task2-monkeyTrouble:");
		System.out.println(obj.monkeyTrouble(true,true));
		System.out.println(obj.monkeyTrouble(false,false));
		System.out.println(obj.monkeyTrouble(true,false));
		//Task 3
		System.out.println("Task3-sumDouble");
		System.out.println(obj.sumDouble(1,2));
		System.out.println(obj.sumDouble(3,2));
		System.out.println(obj.sumDouble(2,2));
		//Task 4
		System.out.println("Task4-diff21");
		System.out.println(obj.diff21(19));
		System.out.println(obj.diff21(10));
		System.out.println(obj.diff21(21));
		

    }
}