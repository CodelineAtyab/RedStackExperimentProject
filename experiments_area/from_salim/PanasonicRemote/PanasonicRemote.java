import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        // Prepare console input and initialize the remote state and temperature.
        Scanner input = new Scanner(System.in);
        boolean isRemoteOn = false;
        int currentTemp = 24;
        boolean exit = false ;

        // Repeat the menu until the user chooses to exit.
        while(!exit){
            // Display the available remote commands.
            System.out.println("Choose an option: 1) on   2) off   3) temp   4) exit");
            // Read the user's choice.
            String state = input.nextLine();

            // Apply the selected command
            switch (state) {
                // Turn the remote on.
                case "on" , "1":
                    isRemoteOn = true;
                    System.out.println("Remote is now ON");
                    break;

                // Turn the remote off.
                case "off" , "2":
                    isRemoteOn = false;
                    System.out.println("Remote is now OFF");
                    break;

                // Show the stored current temperature.
                case "temp" , "3":
                    System.out.println("Current temperature: " + currentTemp + "°C");
                    break;

                // Stop the menu loop when the user chooses to exit.
                case "exit" , "4":
                    exit = true;
                    break;

                // Prompt again when the input does not match a command.
                default:
                    System.out.println("Please enter 1 or on, 2 or off, 3 or temp, 4 or exit");
                    break;
            }
        }

        // Close the Scanner after the user exits.
        input.close();
    }
}
