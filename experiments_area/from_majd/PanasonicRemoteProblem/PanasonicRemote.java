import java.util.Scanner;

public class PanasonicRemote {

    static Scanner scInput = new Scanner(System.in);

    static int currentTemp = 24;

    public static boolean isRemoteOn = false;

    static void displayRemoteStatus() {

        if (isRemoteOn)
            System.out.println("Remote is now ON");
        else
            System.out.println("Remote is now OFF");
    }


    static void Program() {

        String choice = "";
        do {
System.out.println("1) on   2) off   3) temp   4) exit\n");
            choice = scInput.nextLine();

            switch (choice) {
                case "1":
                case "on": {
                    isRemoteOn = true;

                    displayRemoteStatus();

                }

                    break;

                case "2":
                case "off": {
                    isRemoteOn = false;
                    displayRemoteStatus();

                }
                    break;

                case "3":
                case "temp":
                    System.out.println("Current temperature is:" + currentTemp+"°C\n\n");
                    break;

                case "4":
                case "exit":
                    return;
                default:
                    System.out.println("not within the available choices\n\n");
                    break;

            }
        } while (true);

    }

    public static void main(String[] args) {

        Program();

    }

}
