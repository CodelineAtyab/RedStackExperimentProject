import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
    Scanner inputscanner = new Scanner(System.in);  //reads from the keyboard

    boolean isRemoteOn = false; // Remote state: starts OFF
    boolean running = true; // Controls the loop: false means the program stops
    int currentTemp=24;  // Current temperature value


    // Loop: show the menu again after every action except exit
    while(running){
    System.out.println("1) on   2) off   3) temp   4) exit" );
    String userInput = inputscanner.nextLine();  // Read the user's choice 


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
        System.out.println("Current temperature: " + currentTemp + "\u00B0C");
    } else {
        System.out.println("Remote is OFF");
    }
            break;

        case "4":
        case "exit":
            running=false;
            break;
        default:
          System.out.println("invalid input");    // Anything else is not a valid choice
     }


    }
// Close the Scanner when done
inputscanner.close();
    
    }
}












