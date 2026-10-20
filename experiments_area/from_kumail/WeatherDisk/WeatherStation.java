import java.util.Scanner;

public class WeatherStation {
    public static void main(String[] args) {
        Scanner CurTemp = new Scanner(System.in);

        WeatherStation wStat = new WeatherStation();

        System.out.print("Please enter the temperature in Celsius: ");
        String temp = CurTemp.nextLine();

        wStat.currentCelsius = Double.parseDouble(temp);

        System.out.print("The temp in Fahren: ");
        System.out.println(wStat.getFahrenheit());
        System.out.print("The temp in Kelv: ");
        System.out.println(wStat.getKelvin());

        CurTemp.close();
    }

    double currentCelsius = 25.0;

    public double getFahrenheit() {
        return currentCelsius * 9 / 5 + 32;
    }

    public double getKelvin() {
        return currentCelsius + 273.15;
    }

   
}