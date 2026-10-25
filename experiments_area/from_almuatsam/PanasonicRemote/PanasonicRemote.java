import java.util.Scanner;

public class PanasonicRemote {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temperature = 24;
        String choice = "";

        while (!choice.equals("4") && !choice.equals("exit")) {
            System.out.println();
            System.out.println("Panasonic AC Remote");
            System.out.println("1) on");
            System.out.println("2) off");
            System.out.println("3) temp");
            System.out.println("4) exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                case "on":
                    System.out.println("Remote is now ON");
                    break;
                case "2":
                case "off":
                    System.out.println("Remote is now OFF");
                    break;
                case "3":
                case "temp":
                    System.out.println("Current temperature: " + temperature + "°C");
                    break;
                case "4":
                case "exit":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        scanner.close();
    }
}
