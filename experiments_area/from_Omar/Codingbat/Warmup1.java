public class Warmup1 {

  // warm up 1 -- notString
  public String notString(String str) {
    if (str.startsWith("not")) {
      return str;
    }
    return "not " + str;
  }

  return"not "+str;

  // warm up 1 -- missingChar
  public String missingChar(String str, int n) {

  return str.substring(0,n)+str.substring(n+1);

}

  // warm up 1 -- frontBack

public String frontBack(String str) {
    if (str.length() <= 1) {
      return str;
    }

    String mid = str.substring(1, str.length() - 1);

    return str.charAt(str.length() - 1) + mid + str.charAt(0);
  }

  // front3
  public String front3(String str) {
    String front;

    if (str.length() >= 3) {
      front = str.substring(0, 3);
    } else {
      front = str;
    }

    return front + front + front;

  }

}

  // warm up 1 -- backAround
  public String backAround(String str) {
    return str.substring(str.length() - 1) + str + str.substring(str.length() - 1);
}
