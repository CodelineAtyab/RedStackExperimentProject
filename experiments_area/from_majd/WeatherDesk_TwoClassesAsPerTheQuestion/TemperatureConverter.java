import java.util.Scanner;


//Class WeatherStation
public class TemperatureConverter {

    static Scanner scInput = new Scanner(System.in);

    static String readText(String prompt) {

        String inputValue = "";

        System.out.println(prompt);

        inputValue = scInput.nextLine();

        return inputValue;

    }

    static void write(String prompt) {

        System.out.println(prompt);
    }

    
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        weatherStation.currentCelsius = Double.parseDouble(readText("Enter temperature value in celsius:"));

        write("Fahrenheit: " + weatherStation.getFahrenheit() + " / " + "Kelvin: " + weatherStation.getKelvin());

        scInput.close();
    }
}
