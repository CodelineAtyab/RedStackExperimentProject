import java.util.Scanner;

public class PanasonicRemote {

    // Reads commands entered by the user.
    static Scanner scInput = new Scanner(System.in);

    // Stores the remote's current temperature.
    static int currentTemp = 24;

    // Tracks whether the remote is on.
    public static boolean isRemoteOn = false;

    // Prints whether the remote is currently on or off.
    static void displayRemoteStatus() {
        // Selects the status message based on the remote state.
        if (isRemoteOn)
            System.out.println("Remote is now ON");
        else
            System.out.println("Remote is now OFF");
    }


    static void Program() {

        // Repeats the menu until the user chooses to exit.
        String choice = "";
        do {
            // Displays the available commands and reads the user's choice.
            System.out.println("1) on   2) off   3) temp   4) exit");
            choice = scInput.nextLine();

            // Runs the action that matches the user's choice.
            switch (choice) {
                case "1":
                case "on": {
                    // Turns the remote on and displays its status.
                    isRemoteOn = true;

                    displayRemoteStatus();

                }

                    break;

                case "2":
                case "off": {
                    // Turns the remote off and displays its status.
                    isRemoteOn = false;
                    displayRemoteStatus();

                }
                    break;

                case "3":
                case "temp":
                    // Displays the current temperature.
                    System.out.println("Current temperature is:" + currentTemp+"°C\n\n");
                    break;

                case "4":
                case "exit":
                    // Ends the program when the user chooses to exit.
                    return;
                default:
                    // Informs the user when the command is not recognized.
                    System.out.println("not within the available choices\n\n");
                    break;

            }
        } while (true);

    }

    public static void main(String[] args) {
        // Starts the remote control menu.
        Program();

    }

}
