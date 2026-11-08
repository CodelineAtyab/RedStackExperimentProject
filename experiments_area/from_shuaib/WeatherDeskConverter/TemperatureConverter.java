import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args){

        WeatherStation weatherStation = new WeatherStation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter temperature in Celsius: ");
        String celsius = sc.nextLine();

        weatherStation.currentCelsius = Double.parseDouble(celsius);

        System.out.println("Fahrenheit: " + weatherStation.getFahrenheit() + " / " + "Kelvin: " + weatherStation.getKelvin());

    }
}
