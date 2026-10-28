import java.util.Scanner;
public class CodeBat {
    public static Scanner sc=new Scanner(System.in);
     // warm up 1 -- notString
  public String notString(String str) {
    if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
      return str;
    }

    return "not " + str;

  }
  // warm up 1 -- missingChar

  public String missingChar(String str, int n) {
    return str.substring(0, n) + str.substring(n + 1);

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

  // warm up 1 -- backAround
public String backAround(String str) {
  return str.substring(str.length()-1) + str +str.substring(str.length()-1);
}

public static void main(String[] args) {
    CodeBat codeBat=new CodeBat();
    System.out.println(codeBat.notString("candy"));
    System.out.println(codeBat.notString("not bad"));
    System.out.println(codeBat.missingChar("kitten", 1));
    System.out.println(codeBat.frontBack("code"));
    System.out.println(codeBat.front3("Java"));
    System.out.println(codeBat.backAround("cat"));
    sc.close();
}
}
