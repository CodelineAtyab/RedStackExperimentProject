import java.util.Scanner;

public class WeatherStation{

        double currentCelsius = 25.0;

        public double getFahrenheit(){
            return (currentCelsius * 9 / 5 )+ 32;
        }
        public double getKelvin(){
            return (currentCelsius + 273.15) ;
        }

        public static void main(String[] args){
            Scanner weatherObject = new Scanner(System.in);

            WeatherStation station = new WeatherStation();

            System.out.print("Please enter the temperature in Celsius: ");
            String weather = weatherObject.nextLine();

            station.currentCelsius = Double.parseDouble(weather);

            System.out.println("Temperature in Fahrenheit " + station.getFahrenheit());
            System.out.println("Temperature in Kelvin " + station.getKelvin());

            weatherObject.close();

        }



}