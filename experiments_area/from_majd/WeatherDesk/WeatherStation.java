import java.util.Scanner;

public class WeatherStation {

    static Scanner scInput = new Scanner(System.in);
static public double currentCelsius=25.0;


static public double getFahrenheit(){

    return (currentCelsius* 9 / 5)+ 32;

}

static public double getKelvin(){

    return currentCelsius + 273.15;
}

    public static void main(String[] args) {
        String celsius="";

        System.out.print("Enter temperature value in celsius: ");
        
        celsius=scInput.nextLine();
        currentCelsius = Double.parseDouble(celsius);
        
        System.out.println("Fahrenheit: " + getFahrenheit());
        System.out.println("Kelvin: " + getKelvin());

        scInput.close();
    }
}
