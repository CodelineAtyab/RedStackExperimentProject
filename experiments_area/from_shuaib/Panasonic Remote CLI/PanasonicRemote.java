import java.util.Scanner;

public class PanasonicRemote {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        AC ac = new AC();
        boolean stop = false;

        while(!stop){

            System.out.println("\n### Air Conditioner System ###");
			System.out.println("1. Turn AC On");
			System.out.println("2. Turn AC Off");
			System.out.println("3. Check Temperature");
			System.out.println("4. Exit");
			System.out.print("chose from the options above: ");
			String option = sc.nextLine();

			switch (option) {
				case "1":
                    System.out.println(ac.acOn(true));
					break;
				case "2":
					System.out.println(ac.acOn(false));
					break;
				case "3":
					ac.acTemperature();
					break;
                case "4":
					stop = true;
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
        }
    }
}
