import java.util.Scanner;

public class TemperatureConverter {

    static Scanner scInput = new Scanner(System.in);

    static String readText(String prompt) {

        String inputValue = "";

        System.out.println(prompt);

        inputValue = scInput.nextLine();

        return inputValue;

    }

    static void write(String prompt) {

        System.out.println(prompt);
    }

    


    static double currentCelsius = 25.0;

    static double getFahrenheit() {

        return (currentCelsius * 9 / 5) + 32;

    }

    static double getKelvin() {

        return currentCelsius + 273.15;
    }


    public static void main(String[] args) {


        currentCelsius = Double.parseDouble(readText("Enter temperature value in celsius:"));

        write("Fahrenheit: " + getFahrenheit() + " / " + "Kelvin: " +getKelvin());

        scInput.close();
    }
}
