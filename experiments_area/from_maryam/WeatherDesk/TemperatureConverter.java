import java.util.Scanner;

public class TemperatureConverter {

public static void main(String[] args) {

    // Declare variables that you have to use later
    double Celsius = 0;
    double Fahrenheit = 0;
    double Kelvin = 0;

    // Take input from user

    Scanner cakeObject = new Scanner(System.in);
    System.out.print("Please enter the temperature in Celsius: ");
    String userInput = cakeObject.nextLine();

    cakeObject.close();

    Celsius = Double.parseDouble(userInput);

    //process (Calculate) that input
    Fahrenheit = (Celsius * 9 / 5) + 32;
    Kelvin = Celsius + 273.15;

    //Display the output
    System.out.println("Fahrenheit: " + Fahrenheit);
    System.out.println("Kelvin: " + Kelvin);




}}

