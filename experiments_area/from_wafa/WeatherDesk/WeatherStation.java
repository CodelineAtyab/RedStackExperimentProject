import java.util.Scanner;

public class WeatherStation {

     public static void main(String[] args){
        System.out.println("This is Weather ");

        double currentCelsius  = 25.0;

    
        Scanner weatherObject = new Scanner(System.in);

        System.out.println("Please enter the weather in Celsius: ");

        String userInputWeather = weatherObject.nextLine();
        currentCelsius= Double.parseDouble(userInputWeather);

        System.out.println("Fahrenheit degree : " +getFahrenheit(currentCelsius));
        System.out.println("Kelvin degree : " +getKelvin(currentCelsius));

        weatherObject.close();

    }

    public static  double getFahrenheit(double userInputWeather){
        return userInputWeather * 9 / 5 + 32 ;
    }
    public static double getKelvin(double userInputWeather){
        return userInputWeather + 273.15;
    }
   

}
                
   
   

