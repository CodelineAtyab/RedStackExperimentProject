import java.util.Scanner;

public class PanasonicRemote { 

    static boolean isRemoteOn = false;
    static int currentTemp = 24; 
    static boolean running=true;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String choice;

        do{
            menu();
            System.out.println("Please enter (1 or on) (2 or off) (3 or temp) (4 or exit) :  ");
            
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

        } while(!choice.equals("4") && !choice.equals("exit") );

        scanner.close();
    }

    public static void menu(){
        System.out.println("1. ON");
        System.out.println("2. OFF");
        System.out.println("3. TEMP");
        System.out.println("4. EXIT");
    }

   public static void powerOn(){ 
        isRemoteOn = true;
        System.out.println("Remote is now ON");
    }

    public static void powerOff(){ 
        isRemoteOn = false;
        System.out.println("Remote is now OFF");
    }

    public static void temprature(){ 
        System.out.println("Current temperature: " + currentTemp + "°C");
    
    }

    public static void exit(){ 
        running=false;
    }
}