import java.util.Scanner;
public class WeatherStation {

    static double currentCelsius = 25.0;
    public static void main(String[] args) {
         

        Scanner scanner = new Scanner(System.in);
        WeatherStation weatherObject = new WeatherStation();

        System.out.print("Please enter the temperature in Celsius: ");
        String input = scanner.nextLine();

        weatherObject.currentCelsius = Double.parseDouble(input);

        System.out.println("Fahrenheit: " + weatherObject.getFahrenheit());
        System.out.println("Kelvin: " + weatherObject.getKelvin());

        scanner.close();

    }



    public static double getFahrenheit() {
        return currentCelsius * 9 / 5 + 32;
    }

    public static double  getKelvin() {
        return currentCelsius + 273.15;
    }

}
