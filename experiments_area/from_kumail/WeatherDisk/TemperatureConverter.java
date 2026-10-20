import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner CelTemp = new Scanner(System.in);

        System.out.print("please enter the temperature in Cel: ");
        String temp = CelTemp.nextLine();

        double cel = Double.parseDouble(temp);

        double fahr = cel * 9 / 5 + 32;
        double kel = cel + 273.15;

        System.out.print("The temp in Fahr: ");
        System.out.println(fahr);
        System.out.print("The temp in Kel: ");
        System.out.println(kel);

        CelTemp.close();
    }
}