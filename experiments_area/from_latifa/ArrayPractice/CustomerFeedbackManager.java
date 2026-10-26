import java.util.Scanner;

public class CustomerFeedbackManager{
    /*
    class--> will tell you what you do and how you do , how obj look like
    public --> not private 

    static --> no need to create abj
    static means that this method (function) will exist from start till end
    It desn't have a dynamic disappearance behavior

    void --> function desn't return anything
    */ 
	public static void main(String[] args){
        System.out.println("This is working!");

        //Declar Variables that you have to use later with inichializing
        double x = 10.5; // Hardcoding the value
        double y = 5.7;
        double sumResult = 0;
        double divResult = 0;

        double diffResult = 1;
        double mulResult = 1;

        //Take Input from User
        Scanner cakeObject = new Scanner(System.in);

        System.out.println("Please inter the 1st number: ");
        String userInputForNumOne = cakeObject.nextLine();

        System.out.println("Please inter the 1st number: ");
        String userInputForNumTwo = cakeObject.nextLine();        

        cakeObject.close();

        x = Double.parseDouble(userInputForNumOne);
        y = Double.parseDouble(userInputForNumTwo);


        //Process the Input
        sumResult = x + y;
        diffResult = x - y;
        divResult = x / y;
        mulResult = x * y;
        //Display the output
        System.out.print("The sum is: ");
        System.out.println(sumResult);

        System.out.print("The subtraction is: ");
        System.out.println(diffResult);

        System.out.print("The division is: ");
        System.out.println(divResult);

        System.out.print("The multiplication is: ");
        System.out.println(mulResult);
    }
}