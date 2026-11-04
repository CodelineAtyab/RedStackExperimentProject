import java.util.Scanner;

public class CustomerFeedbackManager {
    public static void main(String[] args){
        System.out.println("This is working...");

        // Declea variable that you have to use later
        double x = 10.5;
        double y = 11.7;
        double sumResult = 0;
        double diffResult = 0;

        double divResult = 1;
        double mulResult =1;

        //Take Input from user

        Scanner cakeObject = new Scanner(System.in);

        System.out.print("Please Enter num1 one : ");
        String UserInputOne = cakeObject.nextLine();

        System.out.print("Please Enter num2 one : ");
        String UserInputTwo = cakeObject.nextLine();

        cakeObject.close();

        x = Double.parseDouble(UserInputOne);
        y = Double.parseDouble(UserInputTwo);

        // process calculate the Input
        sumResult = x + y;
        diffResult = x - y;
        divResult = x / y;
        mulResult = x * y;

        // Disple the Output
        System.out.println("The Sum is : " + sumResult);
        System.out.println("The Sum is : " + diffResult);
        System.out.println("The Sum is : " + divResult);
        System.out.println("The Sum is : " + mulResult);
    }
}
