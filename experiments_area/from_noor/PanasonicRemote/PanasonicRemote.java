
import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        Scanner inputscanner = new Scanner(System.in);

        // Set the initial remote state and temperature.
        boolean isRemoteOn = false;
        boolean running = true;
        int currentTemp = 24;

        // Keep showing the menu until the user exits.
        while (running) {
            System.out.println("1) on   2) off   3) temp   4) exit");

            String userInput = inputscanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1":
                case "on":
                    // Turn the remote on.
                    isRemoteOn = true;
                    System.out.println("Remote is now ON");
                    break;

                case "2":
                case "off":
                    // Turn the remote off.
                    isRemoteOn = false;
                    System.out.println("Remote is now OFF");
                    break;

                case "3":
                case "temp":
                    // Display the current temperature.
                    System.out.println("Current temperature: " + currentTemp + "°C");
                    break;

                case "4":
                case "exit":
                    // Exit the program.
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

        inputscanner.close();
    }
}
