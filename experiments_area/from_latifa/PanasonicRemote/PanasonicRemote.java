import java.util.Scanner;

public class PanasonicRemote{

    static boolean isRemoteOn=false;
    static int currentTemp=24;
    public static void main(String[] args){
        System.out.println("Hello, Panasonic Remote!");

        Scanner scanner = new Scanner(System.in);

    
        //boolean running = true;
        String choice;

        do{
        menu();
        System.out.println("Please enter a number to choice: ");
        //Read either a number or a word
        //trim() —> removes extra spaces
        //toLowerCase() —> converts letters to lowercase
        choice = scanner.nextLine().trim().toLowerCase();
        switch (choice) {
            case "1": 
            case "on":
                powerOn();
                break;
            case "2": 
            case "off":
                powerOff();
                break;
            case "3": 
            case "temp":
                temprature();
                break;
            case "4": 
            case "exit":
                exit();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }while(!choice.equals("4") && !choice.equals("exit"));
    scanner.close();
    }

    //show and display the available options
    static void menu(){
        System.out.println("1. ON");
        System.out.println("2. OFF");
        System.out.println("3. TEMP");
        System.out.println("4. EXIT");
    }
    //Turn the remote on and update its state
    public static void powerOn(){
        isRemoteOn = true;
        System.out.println("Remote is now ON");

    }
    //Turn the remote off and update its state
    public static void powerOff(){
        isRemoteOn = false;
        System.out.println("Remote is now OFF");
        
    }
    //Display the current room temperature
    public static void temprature(){
        System.out.println("Current temprature " + currentTemp + "°C");
    }
    public static void exit(){
        System.out.println("Exiting Panasonic Remote, Goodbye!");
    }
}