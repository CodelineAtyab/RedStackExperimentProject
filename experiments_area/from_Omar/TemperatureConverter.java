import java.util.Scanner;

public class TemperatureConverter {
    
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        System.out.print("Enter temperature in Celsius: ");
        String Celsius = new Scanner(System.in).nextLine(); // Set the Celsius temperature to 25.0
        double celsiusValue = Double.parseDouble(Celsius);
        double fahrenheit = weatherStation.convertCelsiusToFahrenheit(celsiusValue);
        double kelvin = weatherStation.convertCelsiusToKelvin(celsiusValue);

        System.out.println("Fahrenheit: " + fahrenheit + "Kelvin: " + kelvin);
    }
}
