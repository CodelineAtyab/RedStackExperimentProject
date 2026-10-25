import java.util.Scanner;

public class WeatherStation {
    static double currentCelsius = 25;
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");

        String celsius = Input.nextLine();
        currentCelsius = Double.parseDouble(celsius);

        System.out.println("---------------------------------");
        System.out.println("Fahrenheit: " + getFahrenheit());
        System.out.println("Kelvin: " + getKelvin());
        System.out.println("---------------------------------");
    }


    public static double getFahrenheit() {
        return (currentCelsius * 9/5) + 32 ;
    }


    public static double getKelvin() {
        return currentCelsius + 273.15 ;
    }
}
