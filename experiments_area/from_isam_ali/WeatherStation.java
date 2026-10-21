import java.util.Scanner;

public class WeatherSituation {

 double currentCelsius = 25.0;

    public double getFahrenheit() {

         return currentCelsius * 9/5+32;
    }
    public double getKelvin() {

         return currentCelsius + 273.15;
    }
    public static void main(String[] args) {

        WeatherSituation weather = new WeatherSituation();

        Scanner input1 = new Scanner(System.in);

        System.out.print("Enter Tempreture in Celcius : ");
        double converter = Double.parseDouble(input1.nextLine());

        System.out.println("in Fahrenheit : " + weather.getFahrenheit());
        System.out.println("in Fahrenheit : " + weather.getKelvin());



       
        
    

        
    }
    
}
