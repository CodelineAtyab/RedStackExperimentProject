import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        // Store the remote's power state and the current temperature.
        boolean isRemoteOn = false;
        int currentTemp = 24;

        // Read 
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display the available remote commands.
            System.out.println("1) on   2) off   3) temp   4) exit");
            System.out.print("Choose an option: ");

            // Stop if there is no more input to read.
            if (!scanner.hasNextLine()) {
                break;
            }

            // Read the user's choice and perform the matching action.
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1", "on":
                    isRemoteOn = true;
                    System.out.println("Remote is now ON");
                    break;
                case "2", "off":
                    isRemoteOn = false;
                    System.out.println("Remote is now OFF");
                    break;
                case "3", "temp":
                    System.out.println("Current temperature: " + currentTemp + " C");
                    break;
                case "4", "exit":
                    running = false;
                    System.out.println("Exiting PanasonicRemote.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }
    }
}
