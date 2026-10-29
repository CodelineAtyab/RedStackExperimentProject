import java.util.Scanner;

public class temprture 
{ 
public static void main(String[] args) 
{
//declare variables that will be used in the program
{
    double celsius= 0;
    double fahrenheit= 0.0;
    double kelvin= 0;
    //take input from user 
      Scanner input = new Scanner(System.in);
    //please enter the temperature in celsius
    System.out.print("Please enter the temperature in celsius: ");
    String userInput = input.nextLine();
      input .close();
      celsius = Double.parseDouble(userInput);
    //Prpcess calculate that input  
    fahrenheit = (celsius * 9/5) + 32;
    kelvin = celsius + 273.15;
    //display the output 
    System.out.println("The temperature in Fahrenheit is: " + fahrenheit);
    System.out.println("The temperature in Kelvin is: " + kelvin);
    System.out.println("Thank you for using the temperature converter!");
}
}
}

