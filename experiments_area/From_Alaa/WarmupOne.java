public class WarmupOne {
  public static void main(String[] args) {
    System.out.println(WarmupOne.sleepIn(false, true));
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

}