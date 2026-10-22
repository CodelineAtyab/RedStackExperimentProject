import java.util.Scanner;

public class PanasonicRemote { 

    public static void main(String[] args){
        System.out.println("Hello, Panasonic Remote");

        Scanner scanner = new Scanner(System.in);
        
        int choice;

        do{
            menu();
            System.out.println("Please enter a number to choice :  ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    powerOn();
                    break;
                case 2:
                    powerOff();
                    break;
                case 3:
                    temprature();
                    break;
                case 4:
                    exit();
                    break;

            
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }while(choice != 4);

        scanner.close();
    }


    public static void menu(){
        System.out.println("ON");
        System.out.println("OFF");
        System.out.println("TEMP");
        System.out.println("EXIT");

    }

   public static void powerOn(){ 
        boolean isOn = true;
        if (isOn == true){ 
            System.out.println("Remote is on");
        }else{
            isOn = false;
            System.out.println("Remote is off");
            }
    }

    public static void powerOff(){ 
        boolean isOn = true;
        if (isOn != false){ 
            System.out.println("Remote is off");
        }else{
            isOn = false;
            System.out.println("Remote is on");
            }
    }

    public static void temprature(){ 
        int currentTemp=24;
        System.out.println("Temprature is set to " + currentTemp + " degrees");
    }

    public static void exit(){ 
        return;
    }
}

