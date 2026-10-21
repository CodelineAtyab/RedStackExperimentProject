import java.util.Scanner;
public class TemperatureConverter {


public static void main (String[] args) {

    // Decleration;

    Scanner input1 = new Scanner(System.in);
    System.out.print("Enter the temperature in Celsius:");
    String temp = input1.nextLine();
    
    double convert = Double.parseDouble(temp);

    double f = convert * 9/5 + 32;
    double k = convert + 273.15;

    System.out.print("The temperature in Fahrenheit is: " + f);
    System.out.println("The temperature in Kelvin is: " + k);

}
}