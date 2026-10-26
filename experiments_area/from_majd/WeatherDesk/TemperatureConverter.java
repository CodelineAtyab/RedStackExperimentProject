import java.util.Scanner;

public class TemperatureConverter {

    static Scanner scInput = new Scanner(System.in);
    static WeatherStation ws = new WeatherStation();

    public static void main(String[] args) {
        String celsius="";

        System.out.print("Enter temperature value in celsius: ");
        
        celsius=scInput.nextLine();
        ws.currentCelsius = Double.parseDouble(celsius);
        
        System.out.println("Fahrenheit: " + ws.getFahrenheit());
        System.out.println("Kelvin: " + ws.getKelvin());

        scInput.close();
    }
}
