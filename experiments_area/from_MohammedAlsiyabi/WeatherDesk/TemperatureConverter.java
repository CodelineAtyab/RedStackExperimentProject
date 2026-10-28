import java.util.Scanner;

public class TemperatureConverter{
    public static void main(String[] args){

        double c = 0;

        Scanner tempObject = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String userInputTemp = tempObject.nextLine();


        tempObject.close();

        c = Double.parseDouble(userInputTemp);

        //C to F
        double Fahrenheit = ( c * 9 / 5 + 32);
        double Kelvin = c + 273.15;

        System.out.println("Temperature in Fahrenheit " + Fahrenheit);
        System.out.println("Temperature in Kelvin " + Kelvin);


    }
}