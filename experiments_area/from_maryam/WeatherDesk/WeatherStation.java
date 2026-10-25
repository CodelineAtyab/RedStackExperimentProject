import java.util.Scanner;

public class WeatherStation {

    double currentCelsius = 25.0;

    // Method to calculate that input
    double getFahrenheit(){
        return  (currentCelsius * 9 / 5) + 32;

    }
    double getKelvin(){

        return  currentCelsius + 273.15;
    }


    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        // Declare variables that you have to use late;
        double Fahrenheit = 0;
        double Kelvin = 0;

        // Take input from user

        Scanner cakeObject = new Scanner(System.in);
        System.out.print("Please enter the temperature in Celsius: ");
        String userInput = cakeObject.nextLine();

        cakeObject.close();
        station.currentCelsius = Double.parseDouble(userInput);


        //Display the output
        System.out.println("Fahrenheit: " + station.getFahrenheit());
        System.out.println("Kelvin: " + station.getKelvin());




    }}



