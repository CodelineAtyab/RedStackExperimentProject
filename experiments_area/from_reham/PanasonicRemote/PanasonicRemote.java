import java.util.Scanner;

public class PanasonicRemote{
    public static void main(String[] args){
        //To take inputs 
        Scanner Menu = new Scanner(System.in);
        System.out.println("Welcome to Panasonic Remote Control"); //Welcome message

        boolean running = true;//To keep the program running until user wants to exit
        boolean isRemoteon = true;//To check if the remote is on or off
        int Currenttemperature =24;
        
        while(running == true){
            //Menu for the user to choose from
            System.out.println("\nMenu");
            System.out.println("1.on \n2.off \n3.temp \n4.exit");

            int choice = Menu.nextInt(); //To take the user input for the menu
            
            switch(choice){ 
                case 1: // if the remote is off turn it on and print the msg 
                    if (isRemoteon == true){ 
                        System.out.println("Remote is now ON");
                    }else{
                        isRemoteon = true;
                        System.out.println("Remote is now OFF");
                    }
                    break;
                case 2:
                    isRemoteon = false;
                    System.out.println("Remote is now OFF");
                    break;
                case 3:

                    System.out.println("Current temperature : "+Currenttemperature+"°C");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input");

            }
         }
    }
}
