import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String celsiusInput = input.nextLine();

        station.currentCelsius = Double.parseDouble(celsiusInput);

        System.out.println("Fahrenheit: " + station.getFahrenheit());
        System.out.println("Kelvin: " + station.getKelvin());

        input.close();
    }
}