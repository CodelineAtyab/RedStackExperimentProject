public class PanasonicRemote {
    
    public static void main(String[] args) {
        int currentTemperature = 24;
        boolean isOn=false;            //Variables used for the state of the remote, while loop and show stored temp values
        boolean stop=false;

        //won't stop until stop = true
        while (!stop) {
    
           System.out.println("+** Panasonic Remote Control **+");
           System.out.println("1. power on");
           System.out.println("2. power off");
           System.out.println("3. temperature");       //options to choose from
           System.out.println("4. exist");
           System.out.print("Choose an option:");

              int option = new java.util.Scanner(System.in).nextInt();  //inputing option value

            switch (option) {
                case 1:
                if (isOn) {
                    System.out.println("The remote is already on.");
                } else {                                                //if the remote is off, turn it on and print the message
                    isOn = true;
                    System.out.println("The remote is now on.");
                }
                break;
                case 2:
                if (!isOn) {
                    System.out.println("The remote is already off.");
                } else {
                    isOn = false;                                          //if the remote is on, turn it off and print the message
                    System.out.println("The remote is now off.");
                }
                break;
                case 3:
                System.out.println("Current temperature: " + currentTemperature);  //print the current temperature
                break;
                case 4:                                 
                System.out.println("Exiting...");
                stop = true;                        //set stop to true to exit the loop and end the program
                break;
                default:
                System.out.println("Invalid option. Please try again.");  //if the user inputs an invalid option, print the message and ask for input again
                break;
            }
    }
}
}