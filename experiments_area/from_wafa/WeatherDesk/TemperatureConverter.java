import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {

        Scanner tempObject = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String userInputTemp = tempObject.nextLine();

        double celsius = Double.parseDouble(userInputTemp);
        double fahrenheit = (celsius * 9 / 5 + 32);
        double kelvin = (celsius + 273.15);
        
        tempObject.close();

        
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);
    }
}