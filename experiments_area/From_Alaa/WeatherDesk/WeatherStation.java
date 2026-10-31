
import java.util.Scanner;

public class WeatherStation {

    // Field of the class (not a local variable in main)
    double currentCelsius = 25.0;

    public static void main(String[] args) {

        Scanner CelsiusScan = new Scanner(System.in);

        System.out.print("Enter current temperature in Celsius: ");
        String tempC = CelsiusScan.nextLine();

        // Create a WeatherStation object
        WeatherStation object = new WeatherStation();

        // Set the object's field using the input
        object.currentCelsius = Double.parseDouble(tempC);

        // Print using the object's methods
        System.out.println("Fahrenheit: " + object.getFahrenheit());
        System.out.println("Kelvin: " + object.getKelvin());

        CelsiusScan.close();
    }

    public double getFahrenheit() {
        return currentCelsius * 9 / 5 + 32;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }
}
