import java.util.Scanner;

public class WeatherStat {
    public double currentCelsius = 30.0;

    public double getFahrenheit() {
        return currentCelsius * 9 / 5 + 32;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }

    public static void main(String[] args) {
        WeatherStat station = new WeatherStat();
        Scanner input = new Scanner(System.in);

        System.out.print("enter the temperature in Celsius: ");
        String userInput = input.nextLine();
        input.close();

        station.currentCelsius = Double.parseDouble(userInput);

        System.out.println("Fahrenheit: " + station.getFahrenheit());
        System.out.println("Kelvin: " + station.getKelvin());
    }
}
