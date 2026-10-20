import java.util.Scanner;
public class WeatherStation {

    public static void main(String[] args) {
        double currentCelsius = 25.0; // default temperature in Celsius

        Scanner CelsiusScan = new Scanner(System.in);
        System.out.println("Enter current temperature in Celsius: ");
        String tempC = CelsiusScan.nextLine();
        currentCelsius = Double.parseDouble(tempC); // convert input to double


        System.out.println("Temperature in Fahrenheit: " + getFahrenheit(currentCelsius));
        System.out.println("Temperature in Kelvin: " + getKelvin(currentCelsius));

    }



    public static double getFahrenheit(double tempC) { //static so that it can be called without creating an instance of the class
        return tempC * 9 / 5 + 32;
    }

    public static double getKelvin(double tempC) {
        return tempC + 273.15;
    }

}