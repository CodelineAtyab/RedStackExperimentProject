import java.util.Scanner;

public class WeatherStation {
    
    double currentCelsius =25.0;

    public double getFahrenheit(){
        return currentCelsius *9 /5 + 32;
    }

    public double getKelvin(){
        return currentCelsius +  273.15;
    }

    
    public static void main(String[] args){

        Scanner tempObject = new Scanner(System.in);
        
        System.out.println("Please enter the temperature in Celsius:");
        String userInputTemp = tempObject.nextLine();
        
        //create station as remote control from class and update current celsius value, convert string to double
        //WeatherStation (weather) --> remote control that enable to access and use the methode and variable within the class.
        WeatherStation station = new WeatherStation();
        station.currentCelsius = Double.parseDouble(userInputTemp);

        tempObject.close();
         
        //output
        System.out.print("Fahrenheit: ");
        System.out.print(station.getFahrenheit());
        System.out.print(" / Kelvin: ");
        System.out.print(station.getKelvin());
    
    }
}