import java.util.Scanner;

public class TemperatureConverter {

    static Scanner scInput = new Scanner(System.in);
    static WeatherStation ws = new WeatherStation();

    public static void main(String[] args) {

        System.out.print("Enter temperature value in celsius: ");
        ws.currentCelsius = Double.parseDouble(scInput.nextLine());
        System.out.println("Fahrenheit: " + ws.getFahrenheit());
        System.out.println("Kelvin: " + ws.getKelvin());

        scInput.close();
    }
}
