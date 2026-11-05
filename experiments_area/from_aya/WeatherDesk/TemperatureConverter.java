import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args){
       

       //var
        double x = Double.parseDouble("0.0");//String -->double
        double f = 0.0;
        double k = 0.0;
        

        //enter the inout
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the temperature in Celsius: ");
        double cc = userInput.nextDouble();


        //calculation
        f = cc * 9 / 5 + 32;
        k = cc + 273.15;

        //calling
        System.out.print("Fahrenheit: " + f + " /");
        System.out.println(" Kelvin: " + k);
        
        userInput.close();
   
    }

}