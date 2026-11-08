import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("Temperature Converter");
        Scanner userTemperature = new Scanner(System.in);

        System.out.print("Enter the Temperature in Celsius: ");
        String cTemp = userTemperature.nextLine();

        double c = Double.parseDouble(cTemp);

        double f = (c * 9/5 ) + 32;
        double k = c + 273.15;

        System.out.println("The Temperature in Fahrenheit: " + f);
        System.out.print("The Temperature in Kelvin: " + k);

        userTemperature.close();
    }
}
