import java.util.Scanner;

public class CustomerFeedbackManager {
  /*
  Static means that this method (function) will exist from start till end
  It doesn't have a dynamic disappearance behavior
  */  
  public static void main(String[] args) {
      System.out.println("This is working!");
      
      // Declare Variables that you have to use later
      double x = 10.5;  // Hardcoding the values
      double y = 5.7;
      double sumResult = 0;
      double diffResult = 0;

      double divResult = 1;
      double mulResult = 1;
      

      // Take Input from User
      Scanner cakeObject = new Scanner(System.in);

      System.out.print("Please enter the 1st number: ");
      String userInputForNumOne = cakeObject.nextLine();

      System.out.print("Please enter the 2nd number: ");
      String userInputForNumTwo = cakeObject.nextLine();

      cakeObject.close();

      x = Double.parseDouble(userInputForNumOne);
      y = Double.parseDouble(userInputForNumTwo);

      // Process (Calculate) that Input
      sumResult = x + y;
      diffResult = x - y;
      divResult = x / y;
      mulResult = x * y;

      // Display the output
      System.out.print("The sum is: ");
      System.out.println(sumResult);

      System.out.print("The subtraction result is: ");
      System.out.println(diffResult);

      System.out.print("The division result is: ");
      System.out.println(divResult);

      System.out.print("The multiplication result is: ");
      System.out.println(mulResult);
      
    }
}