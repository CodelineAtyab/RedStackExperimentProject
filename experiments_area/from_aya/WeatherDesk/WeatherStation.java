
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
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String x = userInput.nextLine();
        double c = Double.parseDouble(x);


         //create object with weatherStation class 
        WeatherStation w = new WeatherStation(); 
        w.currentCelsius = c;//store the value that the user enter in the object  

        System.out.println("Fahrenheit: " + w.getFahrenheit());
        System.out.println("Kelvin: " + w.getKelvin());

        userInput.close();
    }
}
