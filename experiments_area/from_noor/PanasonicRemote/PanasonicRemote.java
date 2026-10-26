
import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        Scanner inputscanner = new Scanner(System.in);

        boolean isRemoteOn = false;
        boolean running = true;
        int currentTemp = 24;

        while (running) {
            System.out.println("1) on   2) off   3) temp   4) exit");

            String userInput = inputscanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1":
                case "on":
                    isRemoteOn = true;
                    System.out.println("Remote is now ON");
                    break;

                case "2":
                case "off":
                    isRemoteOn = false;
                    System.out.println("Remote is now OFF");
                    break;

                case "3":
                case "temp":
                    if (isRemoteOn) {
                        System.out.println("Current temperature: " + currentTemp + "°C");
                        System.out.println("1) Increase  2) Decrease");

                        String tempChoice = inputscanner.nextLine().trim();

                        if (tempChoice.equals("1")) {
                            if (currentTemp < 30) {
                                currentTemp++;
                            } else {
                                System.out.println("Maximum temperature is 30°C");
                            }
                        } else if (tempChoice.equals("2")) {
                            if (currentTemp > 16) {
                                currentTemp--;
                            } else {
                                System.out.println("Minimum temperature is 16°C");
                            }
                        } else {
                            System.out.println("Invalid temperature option");
                        }

                        System.out.println("Current temperature: " + currentTemp + "°C");
                    } else {
                        System.out.println("Remote is OFF");
                    }
                    break;

                case "4":
                case "exit":
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