
import java.util.Scanner;  // importing the Scanner class from the java.util package to read user input
public class PanasonicRemote{ // class is a blueprint for creating objects, it defines the properties and behaviors of the objects
    
    //void is a return type that indicates the method does not return any value
    //void main is the entry point of the program, it is where the program starts executing
    //statice variable meaning it is shared by all instances of the class and exists from the time the class is loaded until the program ends
    public static void main (String [] args){ 
        boolean exit = false; // variable to keep track of whether the program should exit or not
        boolean isRemoteOn = false; // variable to keep track of the remote's power state   

        while (exit == false){ // loop that continues until the exit variable is set to true
        Scanner RemoteChoice = new Scanner(System.in); // creating a Scanner object to read user input
        System.out.println("menue : 1.on  2.Off  3.temp  4.exit");
        System.out.print("Enter your choice: "); // prompting the user to enter a choice
        String input = RemoteChoice.nextLine(); // reading user input as a string
        
            if (isRemoteOn == false){ // checking if the remote is off
                System.out.println("Remote is Off"); // printing a message indicating that the remote is off
            }
            else{
                System.out.println("Remote is On"); // printing a message indicating that the remote is on
            }
            System.out.println("menue : 1.on  2.Off  3.temp  4.exit");
            System.out.print("Enter your choice: "); // prompting the user to enter a choice
            input = RemoteChoice.nextLine(); // reading user input as a string
        
        if (input.equals("1") || input.equals("on")){ // checking if the user input is equal to "1"
            PanasonicRemote remote = new PanasonicRemote(); // creating an object of the PanasonicRemote class
            remote.powerOn(1); // calling the powerOn method of the remote object
            isRemoteOn = true; 
        }

        else if (input.equals("2") || input.equals("off")){ 
            PanasonicRemote remote = new PanasonicRemote(); 
            isRemoteOn = false;
            remote.powerOff(2); 
            isRemoteOn = false; 
        }

        else if (input.equals("3") || input.equals("temp")){    
            Scanner TempScanner = new Scanner(System.in); // creating a Scanner object to read user input          
            System.out.println("Enter Temprature: "); // prompting the user to enter a temperature value   
            int temp = TempScanner.nextInt(); // reading user input as an integer
            PanasonicRemote remote = new PanasonicRemote(); // creating an object of the PanasonicRemote class
            remote.temprature(temp); 
        }

        else if (input.equals("4") || input.equals("exit")){ 
            PanasonicRemote remote = new PanasonicRemote(); // creating an object of the PanasonicRemote class
            remote.exit(4); // calling the exit method of the remote object
            exit = true;
        }
        
        else{
            System.out.println("Invalid Input"); // printing an error message for invalid input
        }
        }
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