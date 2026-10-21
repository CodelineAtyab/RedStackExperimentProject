import java.util.Scanner;

public class WeatherStation {
    double currentCelsius = 25.0;

    public double getFahrenheit() {
        return currentCelsius * 9 / 5 + 32;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the temperature in Celsius: ");
            String input = scanner.nextLine();
            station.currentCelsius = Double.parseDouble(input);

            System.out.println("Fahrenheit: " + station.getFahrenheit());
            System.out.println("Kelvin: " + station.getKelvin());
        }
    }
}