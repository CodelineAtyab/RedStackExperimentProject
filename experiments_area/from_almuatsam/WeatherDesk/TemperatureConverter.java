import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius:");
        String input = scanner.nextLine();
        double c = Double.parseDouble(input);

        double fahrenheit = c * 9 / 5 + 32;
        double kelvin = c + 273.15;

        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);

        scanner.close();
    }
}
