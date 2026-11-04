import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner CelTemp = new Scanner(System.in);

        System.out.print("please enter the temperature in Cel: ");
        String temp = CelTemp.nextLine();

        double cel = Double.parseDouble(temp);

        double fahrenheit = cel * 9 / 5 + 32;
        double kelvin = cel + 273.15;

        System.out.print("The temp in Fahrenheit: ");
        System.out.println(fahrenheit);
        System.out.print("The temp in Kelvin: ");
        System.out.println(kelvin);

        CelTemp.close();
    }
}