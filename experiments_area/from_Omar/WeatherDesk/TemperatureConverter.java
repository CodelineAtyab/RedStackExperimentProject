import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.print("Enter temperature in Celsius: ");
        WeatherStation weatherStation=new WeatherStation();
        String Celsius = new Scanner(System.in).nextLine();
        weatherStation.Celsius = Double.parseDouble(Celsius);
        double fahrenheit = weatherStation.convertCelsiusToFahrenheit(celsiusValue);
        double kelvin = weatherStation.convertCelsiusToKelvin(celsiusValue);

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("/ Kelvin: " + kelvin);
    }

}
