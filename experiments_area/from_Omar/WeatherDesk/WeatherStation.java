package WeatherDesk;
import java.util.Scanner;
public class WeatherStation {
    public double Celsius = 25.0;
    public static Scanner  sc = new Scanner(System.in);
    public double convertCelsiusToFahrenheit(double Celsius) {
        double Fahrenheit = Celsius * 9 / 5 + 32;
        return Fahrenheit;
    }

    public double convertCelsiusToKelvin(double Celsius) {
        double Kelvin = Celsius + 273.15;
        return Kelvin;
    }

    public static void main(String[] args) {
        System.out.print("Enter temperature in Celsius: ");
        WeatherStation weatherStation=new WeatherStation();
        String Celsius = sc.nextLine();
        weatherStation.Celsius = Double.parseDouble(Celsius);
        double fahrenheit = weatherStation.convertCelsiusToFahrenheit(weatherStation.Celsius);
        double kelvin = weatherStation.convertCelsiusToKelvin(weatherStation.Celsius);

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("/ Kelvin: " + kelvin);

}
}
