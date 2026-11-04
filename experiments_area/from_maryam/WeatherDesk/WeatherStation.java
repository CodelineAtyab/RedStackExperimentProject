import java.util.Scanner;

public class WeatherStation {

    double currentCelsius = 25.0;

    // Method to calculate that input
    double getfahrenheit(){
        return  (currentCelsius * 9 / 5) + 32;

    }
    double getKelvin(){

        return  currentCelsius + 273.15;
    }


    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        // Declare variables that you have to use late;
        double fahrnheit = 0;
        double kelvin = 0;

        // Take input from user

        Scanner cakeObject = new Scanner(System.in);
        System.out.print("Please enter the temperature in Celsius: ");
        String userInput = cakeObject.nextLine();

        cakeObject.close();
        station.currentCelsius = Double.parseDouble(userInput);


        //Display the output
        System.out.println("fahrnheit: ");
        System.out.println(station.getfahrenheit());
        System.out.println("kelvin: ");
        System.out.println(station.getKelvin());



    }}



