import java.util.Scanner;

public class PanasonicRemote {
	
	static int temperature = 24;

	public static String acOn(boolean isRemoteOn) {
		if (isRemoteOn) {
			return "Remote is now ON.";
		} else {
			return "Remote is now OFF.";
		}
	}

	public static void acTemperature() {
		System.out.println("Current temperature: " + temperature + " C");
	}

	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
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
                    System.out.println(acOn(true));
					break;
				case "2":
					System.out.println(acOn(false));
					break;
				case "3":
					acTemperature();
					break;
                case "4":
					stop = true;
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
        }
		sc.close();
    }
}
