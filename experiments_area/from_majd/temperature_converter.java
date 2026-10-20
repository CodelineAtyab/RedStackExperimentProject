import java.util.Scanner;

public class temperature_converter  {
    

static Scanner scInput=new Scanner(System.in);
    

static String readText(String prompt){

        String inputValue="";

        System.out.println(prompt);

        inputValue=scInput.nextLine();

        return inputValue;

    }

    static void write(String prompt){

        System.out.println(prompt);
    }

    public static void main(String[] args){

WeatherStation weatherStation=new WeatherStation();

weatherStation.currentCelsius=Double.parseDouble(readText("Enter temperature in celsius:"));

write("Fahrenheit: "+weatherStation.getFahrenheit()+" / "+"Kalvin: "+weatherStation.getKelvin());

    }
}
