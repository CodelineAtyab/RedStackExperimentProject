import java.util.Scanner;

public class WeatherStation{

    static double CurrentCelsius = 25.0;


    public  double getFahrenheit(){
        return   CurrentCelsius * 9/5+32;
    }

    public  double getKelvin(){
        return C +273.15;
    }

    public static void main(String[] args){

    Scanner Celsiustemp = new Scanner (System.in); // Scanner input 
    WeatherStation station = new WeatherStation();

        // ENTER THE INPUT:
    System.out.println("Enter Temp in Celsius: ");

    station.CurrentCelsius =Celsiustemp.nextDouble();

    System.out.println("Fahrenheit:" +  station.getFahrenheit());
    System.out.println("Kelvin:" +  station.getKelvin());

    // to close the scanner 
    Celsiustemp.close();




    }



}