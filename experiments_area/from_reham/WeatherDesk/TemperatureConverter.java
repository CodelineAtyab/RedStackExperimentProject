import java.util.Scanner;
public class TemperatureConverter { 
    public static void main(String[] args) { 
        Scanner Temp = new Scanner (System.in);
        System.out.println("Enter your temperature in Celsius: ");
        String CTemp =Temp.nextLine();
        double currentCelsius = Double.parseDouble(CTemp); //Convert from String to double 
        double getFahrenheit = (currentCelsius * 9/5+32);
        double getKelvin = (currentCelsius +273.15);

        System.out.println("Fahrenheit: " + getFahrenheit + " / Kelvin: " + getKelvin);


        }

}