import java.util.Scanner;
public class PanasonicRemote {
    public static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int currentTemperature = 24;
        boolean isOn = false; // Variables used for the state of the remote, while loop and show stored temp
                              // values
        boolean stop = false;


        // won't stop until stop = true
        while (!stop) {

            System.out.println("+** Panasonic Remote Control **+");
            System.out.println("1. power on");
            System.out.println("2. power off");
            System.out.println("3. temperature"); // options to choose from
            System.out.println("4. exit");
            System.out.print("Choose an option:");

            String option= sc.nextLine(); // inputing option value

            
            switch (option) {
                case "1", "on":
                    if (isOn) {
                        System.out.println("Remote is now ON");
                    } else { // if the remote is off, turn it on and print the message
                        isOn = true;
                        System.out.println("Remote is now ON");
                    }
                    break;
                case "2" , "off":
                    if (!isOn) {
                        System.out.println("The remote is already off.");
                    } else {
                        isOn = false; // if the remote is on, turn it off and print the message
                        System.out.println("The remote is now off.");
                    }
                    break;
                case "3" , "temp":
                    System.out.println("Current temperature: " + currentTemperature+"°C"); // print the current temperature
                    break;
                case "4" , "exit":
                    System.out.println("Exiting...");
                    stop = true; // set stop to true to exit the loop and end the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // if the user inputs an invalid option,
                                                                             // print the message and ask for input
                                                                             // again
                    break;
            }
        }
        sc.close();
    }
}