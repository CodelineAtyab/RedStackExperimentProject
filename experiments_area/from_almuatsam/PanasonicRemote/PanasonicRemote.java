import java.util.Scanner;

public class PanasonicRemote {

    private static final int MIN_TEMPERATURE = 16;
    private static final int MAX_TEMPERATURE = 30;

    public static void main(String[] args) {
        // Store the remote state and current temperature.
        int currentTemp = 24;
        boolean isRemoteOn = false;
        boolean shouldExit = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!shouldExit) {
                // Display the menu and read the user's command.
                printMenu();

                if (!scanner.hasNextLine()) {
                    break;
                }
                String choice = scanner.nextLine().trim().toLowerCase();

                // Handle the selected remote command.
                switch (choice) {
                    case "1":
                    case "on":
                        if (isRemoteOn) {
                            System.out.println("Remote is already ON");
                        } else {
                            isRemoteOn = true;
                            System.out.println("Remote is now ON");
                        }
                        break;
                    case "2":
                    case "off":
                        if (isRemoteOn) {
                            isRemoteOn = false;
                            System.out.println("Remote is now OFF");
                        } else {
                            System.out.println("Remote is already OFF");
                        }
                        break;
                    case "3":
                    case "temp":
                        if (requireOn(isRemoteOn)) {
                            System.out.println("Current temperature: " + currentTemp + "°C");
                        }
                        break;
                    case "4":
                    case "up":
                        if (requireOn(isRemoteOn)) {
                            if (currentTemp >= MAX_TEMPERATURE) {
                                System.out.println("Maximum temperature is " + MAX_TEMPERATURE + "°C");
                            } else {
                                currentTemp++;
                                System.out.println("Temperature increased to " + currentTemp + "°C");
                            }
                        }
                        break;
                    case "5":
                    case "down":
                        if (requireOn(isRemoteOn)) {
                            if (currentTemp <= MIN_TEMPERATURE) {
                                System.out.println("Minimum temperature is " + MIN_TEMPERATURE + "°C");
                            } else {
                                currentTemp--;
                                System.out.println("Temperature decreased to " + currentTemp + "°C");
                            }
                        }
                        break;
                    case "6":
                    case "exit":
                        System.out.println("Goodbye");
                        shouldExit = true;
                        break;
                    default:
                        System.out.println("Invalid option, please enter 1-6 or a command name");
                        break;
                }
            }
        }
    }

    // Display the available commands.
    private static void printMenu() {
        System.out.println();
        System.out.println("Panasonic AC Remote");
        System.out.println("1) on");
        System.out.println("2) off");
        System.out.println("3) temp");
        System.out.println("4) up");
        System.out.println("5) down");
        System.out.println("6) exit");
        System.out.print("Choose an option: ");
    }

    // Check whether the remote is on before changing its settings.
    private static boolean requireOn(boolean isRemoteOn) {
        if (!isRemoteOn) {
            System.out.println("Remote is OFF, turn it on first");
        }
        return isRemoteOn;
    }
}
