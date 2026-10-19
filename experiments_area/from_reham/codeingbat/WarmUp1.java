class WarmUp1{
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
    public static void main(){
		WarmUp1 obj = new WarmUp1();
		System.out.println(obj.sleepIn(true, false));
        System.out.println(obj.sleepIn(false, false));
        System.out.println(obj.sleepIn(false, true));

    }
}