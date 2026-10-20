import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isRemoteOn = false;
        int currentTemp = 24;
        boolean exit = false ;

        // Repeat the menu until the user chooses to exit.
        while(!exit){
            System.out.println("Choose an option: 1) on   2) off   3) temp   4) exit");
            // Read the user's choice.
            String state = input.nextLine();

            switch (state) {
                case "on" , "1":
                    isRemoteOn = true;
                    System.out.println("Remote is now ON");
                    break;

                case "off" , "2":
                    isRemoteOn = false;
                    System.out.println("Remote is now OFF");
                    break;

                case "temp" , "3":
                    System.out.println("Current temperature: " + currentTemp + "°C");
                    break;

                case "exit" , "4":
                    exit = true;
                    break;

                default:
                    System.out.println("Please enter 1 or on, 2 or off, 3 or temp, 4 or exit");
                    break;
            }
        }

        // Close the Scanner after the user exits.
        input.close();
    }
}