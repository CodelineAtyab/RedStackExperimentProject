import java.util.Scanner;
public class TemperatureConverter {
    
    public static void main(String[] args) {
        System.out.println("Temperature Converter");
        Scanner input = new Scanner(System.in);


        System.out.print("Enter temperature in Celsius: ");
        String celsiusInput = input.nextLine();


        double celsius = Double.parseDouble(celsiusInput);
        double fahrenheit = (celsius * 9/5) + 32;

        System.out.println("---------------------------------");
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
        System.out.println("---------------------------------");
    }
}
