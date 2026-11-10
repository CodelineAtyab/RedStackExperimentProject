import java.util.Scanner;

public class TemperatureConverter{
   public static void main(String[] args){
    //Declar Variables
    double fahrenheitResult;
    double kelvinResult;
    double c;

    // Take input--> Ask: Please enter the temperature in Celsius:  
    Scanner tempObject = new Scanner(System.in);

    System.out.println("Please enter the temperature in Celsius");
    String userInputTemp = tempObject.nextLine();

    tempObject.close();

    //Read it as a String and convert it to a double.
    c = Double.parseDouble(userInputTemp);
    

   // process the input--> Calculate Fahrenheit (c * 9 / 5 + 32) and Kelvin (c + 273.15).
    fahrenheitResult = c * 9 / 5 + 32;
    kelvinResult = c + 273.15;

    //display output--> Print both results.
    System.out.println("Fahrenheit: "+fahrenheitResult);
    //System.out.print(fahrenheitResult);

    System.out.println("Kelvin: "+kelvinResult);
    //System.out.print(kelvinResult);

    }
}
   
   
