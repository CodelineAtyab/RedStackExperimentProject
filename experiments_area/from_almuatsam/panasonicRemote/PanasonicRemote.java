
import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean isOn = false;
        int currentTemp = 24;
        String choice = "";

       
        while (!choice.equals("4")) {
            // Display the remote menu.
            System.out.println("\nPanasonic AC Remote");
            System.out.println("1) On");
            System.out.println("2) Off");
            System.out.println("3) Temperature");
            System.out.println("4) Exit");
            System.out.print("What option do you want to choose? ");

            
            choice = scanner.nextLine().trim();

            
            switch (choice) {
                case "1":
                    
                    if (!isOn) {
                        isOn = true;
                        System.out.println("AC is now ON");
                    } else {
                        System.out.println("AC is already ON");
                    }
                    break;

                case "2":
                    
                    if (isOn) {
                        isOn = false;
                        System.out.println("AC is now OFF");
                    } else {
                        System.out.println("AC is already OFF");
                    }
                    break;

                case "3":
                    
                    if (isOn) {
                        System.out.println(
                                "Current temperature: " + currentTemp + " C");
                        System.out.print("Enter new temperature (16-30): ");

                        
                        String temperatureInput = scanner.nextLine().trim();

                        try {
                            
                            int newTemp = Integer.parseInt(temperatureInput);

                            
                            if (newTemp >= 16 && newTemp <= 30) {
                                currentTemp = newTemp;
                                System.out.println(
                                        "Temperature set to " + currentTemp + " C.");
                            } else {
                                System.out.println(
                                        "Enter a temperature from 16 to 30.");
                            }
                        } catch (NumberFormatException e) {
                           
                            System.out.println(
                                    "Please enter a valid whole number.");
                        }
                    } else {
                        
                        System.out.println(
                                "Turn on the AC before setting temperature.");
                    }
                    break;

                case "4":
                    
                    System.out.println("Remote shutting down.");
                    break;

                default:
                    
                    System.out.println(
                            "Invalid option. Select 1, 2, 3 or 4.");
                    break;
            }
        }

        scanner.close();
    }
}
