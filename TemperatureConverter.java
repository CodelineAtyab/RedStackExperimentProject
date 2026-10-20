import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] srgs){

        System.out.println("this temperature degree !");


        Scanner tempObject = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String userInputTemp = tempObject.nextLine();


        

        double celsius = Double.parseDouble(userInputTemp);

        double fahrenheit = (celsius * 9 / 5 + 32);
        double kelvin =  (celsius + 273.15);

        tempObject.close();

        System.out.print("The Celsius is: " );
        System.out.println(celsius);

        System.out.print("The Fahrenheit is: " );
        System.out.println(fahrenheit);

        System.out.print("The Kelvin  is: " );
        System.out.println(kelvin);
        
        
}
}