import java.util.Scanner;


public class TempConv {
   public static void main(String[] args){
    double celsius = 0.0;
    double fahrenheit = 0.0;
    double kelvin = 0.0;


    //for reading the temperature from the user
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the temperature in Celsius: ");
    String userInput = input.nextLine();
    input.close();


    // now for the converting to f and k
    celsius = Double.parseDouble(userInput);
    fahrenheit = celsius * 9 / 5 + 32;
    kelvin = celsius + 273.15;

    //to display

    System.out.println("Fahrenheit: " + fahrenheit);
    System.out.println("Kelvin: " + kelvin);
   }
}