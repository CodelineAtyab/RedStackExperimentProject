import java.util.Scanner;

public class PanasonicRemote {

    private static final int MIN_TEMPERATURE = 16;
    private static final int MAX_TEMPERATURE = 30;
    private static final int DEFAULT_TEMPERATURE = 24;

    public static void main(String[] args) {
        int temperature = DEFAULT_TEMPERATURE;
        boolean isOn = false;
        boolean shouldExit = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!shouldExit) {
                printMenu();

                if (!scanner.hasNextLine()) {
                    break;
                }
                String choice = scanner.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "1":
                    case "on":
                        if (isOn) {
                            System.out.println("Remote is already ON");
                        } else {
                            isOn = true;
                            System.out.println("Remote is now ON");
                        }
                        break;
                    case "2":
                    case "off":
                        if (isOn) {
                            isOn = false;
                            System.out.println("Remote is now OFF");
                        } else {
                            System.out.println("Remote is already OFF");
                        }
                        break;
                    case "3":
                    case "temp":
                        if (requireOn(isOn)) {
                            System.out.println("Current temperature: " + temperature + "°C");
                        }
                        break;
                    case "4":
                    case "up":
                        if (requireOn(isOn)) {
                            if (temperature >= MAX_TEMPERATURE) {
                                System.out.println("Maximum temperature is " + MAX_TEMPERATURE + "°C");
                            } else {
                                temperature++;
                                System.out.println("Temperature increased to " + temperature + "°C");
                            }
                        }
                        break;
                    case "5":
                    case "down":
                        if (requireOn(isOn)) {
                            if (temperature <= MIN_TEMPERATURE) {
                                System.out.println("Minimum temperature is " + MIN_TEMPERATURE + "°C");
                            } else {
                                temperature--;
                                System.out.println("Temperature decreased to " + temperature + "°C");
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

    private static boolean requireOn(boolean isOn) {
        if (!isOn) {
            System.out.println("Remote is OFF, turn it on first");
        }
        return isOn;
    }
}
