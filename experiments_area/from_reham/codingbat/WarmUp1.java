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
	
	//Task 5
	public boolean parrotTrouble(boolean talking, int hour) {
	  if (talking && hour<7){
		return true;
	  }else if(talking&& hour>20){
		
		return true;
	  }else{
		return false;
	  }
	}
	
	//Task 6
	public boolean makes10(int a, int b) {
	  if (a==10 || b==10){
		return true;
	  }else if (a+b==10){
		return true;
	  }else{
		return false;
	  }
	}
	
	//Task 7
	
	public boolean nearHundred(int n) {
	  if (Math.abs(100-n)<=10){
		return true;
	  }else if (Math.abs(200-n)<=10) {
		return true;
	  }else{
		return false;
	  }
	}
	
	//Task 8
	
	public boolean posNeg(int a, int b, boolean negative) {
	 if (negative) {
		return (a < 0 && b < 0);
	  }
	  else {
		return ((a < 0 && b > 0) || (a > 0 && b < 0));
	  }
	}
	
	
	//Task 9
	public String notString(String str) {
	if (str.length() >=3 &&str.substring(0, 3).equals("not")){
		return str;
	}else{
		return "not "+str;
	}
	}


	
    public static void main(){
		WarmUp1 obj = new WarmUp1();
		//Task 1
		System.out.println("\nTask1-sleepIn:");
		System.out.println(obj.sleepIn(true, false));
        System.out.println(obj.sleepIn(false, false));
        System.out.println(obj.sleepIn(false, true));
		//Task 2
		System.out.println("\nTask2-monkeyTrouble:");
		System.out.println(obj.monkeyTrouble(true,true));
		System.out.println(obj.monkeyTrouble(false,false));
		System.out.println(obj.monkeyTrouble(true,false));
		//Task 3
		System.out.println("\nTask3-sumDouble");
		System.out.println(obj.sumDouble(1,2));
		System.out.println(obj.sumDouble(3,2));
		System.out.println(obj.sumDouble(2,2));
		//Task 4
		System.out.println("\nTask4-diff21");
		System.out.println(obj.diff21(19));
		System.out.println(obj.diff21(10));
		System.out.println(obj.diff21(21));
		//Task 5
		System.out.println("\nTask5-parrotTrouble");
		System.out.println(obj.parrotTrouble(true,6));
		System.out.println(obj.parrotTrouble(true,7));
		System.out.println(obj.parrotTrouble(false,6));
		//Task 6
		System.out.println("\nTask6-makes10");
		System.out.println(obj.makes10(9,10));
		System.out.println(obj.makes10(9,19));
		System.out.println(obj.makes10(1,9));
		//Task 7
		System.out.println("\nTask7-nearHundred");
		System.out.println(obj.nearHundred(93));
		System.out.println(obj.nearHundred(90));
		System.out.println(obj.nearHundred(89));
		//Task 8 
		System.out.println("\nTask8-posNeg");
		System.out.println(obj.posNeg(1,-1,false));
		System.out.println(obj.posNeg(-1,1,false));
		System.out.println(obj.posNeg(-4,-5,true));
		//Task 9
		System.out.println("\nTask9-notString");
		System.out.println(obj.notString("Candy"));
		System.out.println(obj.notString("X"));
		System.out.println(obj.notString("not bad"));

    }
}