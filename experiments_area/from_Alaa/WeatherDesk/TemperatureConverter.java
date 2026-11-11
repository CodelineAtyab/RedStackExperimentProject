import java.util.Scanner;
public class TemperatureConverter {
    
    public static void main(String[] args) {
        double celsius = 0.0;
        double fahrenheit = 0.0;
        double kelvin = 0.0;

        Scanner temp = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        String input = temp.nextLine();
        celsius = Double.parseDouble(input);

        fahrenheit = (celsius * 9 / 5) + 32;
        kelvin = celsius + 273.15;

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);
        
    }
    
    
   
}