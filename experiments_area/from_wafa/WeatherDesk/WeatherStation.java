import java.util.Scanner;
public class WeatherStation {

    public static void main(String[] args) {
        double currentCelsius = 25.0; 

        Scanner Celsius = new Scanner(System.in);
        System.out.print("Please enter current temperature in Celsius: ");

        String watherObject = Celsius.nextLine();

        currentCelsius = Double.parseDouble(watherObject); 


        System.out.println("Fahrenheit degree : " + getFahrenheit(currentCelsius));
        System.out.println("Kelvin degree : " + getKelvin(currentCelsius));

    }



    public static double getFahrenheit(double watherObject) { 
        return watherObject * 9 / 5 + 32;
    }

    public static double getKelvin(double watherObject) {
        return watherObject + 273.15;
    }

}
