import java.util.Scanner;
public class WeatherStation {

    double currentCelsius = 25.0;

    double getFahrenheit() {
        return c * 9 / 5 + 32;
    }

    double getKelvin() {
        return c + 273.15;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        WeatherStation station = new WeatherStation();

        System.out.print("Please enter the temperature in Celsius: ");
        String input = scanner.nextLine();
        station.currentCelsius = Double.parseDouble(input);

        System.out.println("Fahrenheit: " + station.getFahrenheit());
        System.out.println("Kelvin: " + station.getKelvin());

        scanner.close();
    }
}
