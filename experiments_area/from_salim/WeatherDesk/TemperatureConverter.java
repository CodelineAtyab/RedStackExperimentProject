import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");

        String cInput = scanner.nextLine();

        Double c = Double.parseDouble(cInput);

        double f = c * 9 / 5 + 32;
        double k = c + 273.15 ;

        System.out.println("Fahrenheit: " + f);
        System.out.println("Kelvin: " + k);

        scanner.close();
    }
}