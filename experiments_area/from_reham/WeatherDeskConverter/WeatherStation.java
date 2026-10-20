import java.util.Scanner;

public class WeatherStation{

    public static double getFahrenheit(double C ){
        return   C * 9/5+32;
    }

    public static double getKelvin(double C){
        return C +273.15;
    }

    public static void main(String[] args){
    double CurrentCelsius = 25.0;
    Scanner Celsiustemp = new Scanner (System.in);
    System.out.println("Enter Temp in Celsius: ");
    double CTemp = Celsiustemp.nextDouble();

    System.out.println("Temp in F:" +  getFahrenheit(CTemp));
    System.out.println("Temp in k:" +  getKelvin(CTemp));


    }



}