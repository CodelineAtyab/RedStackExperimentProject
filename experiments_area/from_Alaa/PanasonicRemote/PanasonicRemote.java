
import java.util.Scanner;  // importing the Scanner class from the java.util package to read user input
public class PanasonicRemote{ // class is a blueprint for creating objects, it defines the properties and behaviors of the objects
    
    //void is a return type that indicates the method does not return any value
    //void main is the entry point of the program, it is where the program starts executing
    //statice variable meaning it is shared by all instances of the class and exists from the time the class is loaded until the program ends
    public static void main (String [] args){ 
        boolean exit = false; // variable to keep track of whether the program should exit or not
        boolean isRemoteOn = false; // variable to keep track of the remote's power state
        int currentTemp = 24; // variable to store the current temperature
        Scanner RemoteChoice = new Scanner(System.in); // creating a Scanner object to read user input

        // loop that continues until the exit variable is set to true
        while (exit == false){

            // display the menu and read the user's choice
            System.out.println("1) on   2) off   3) temp   4) exit");
            String input = RemoteChoice.nextLine().trim().toLowerCase();

            // switch statement handles numeric and word inputs
            switch (input) {
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
                    System.out.println("Current temperature: " + currentTemp + "°C");
                    break;

                case "4":
                case "exit":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

        RemoteChoice.close();
    }

    public void powerOn(int x){ // method to turn on the power
        System.out.println("Remote is now On");
    }

    public void powerOff(int y){ // method to turn off the power
        System.out.println("Remote is now Off");
    }

    public void temprature(int z){ // method to set the temperature
        System.out.println("Temprature is set to " + z + " degrees");
    }

    public void exit(int a){ // method to exit the program
        return;
    }
}
