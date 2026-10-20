import java.util.Scanner;

public class hello {
	public static void main(String[] args) {

		System.out.println("Hello World");

		Scanner sc = new Scanner(System.in);

		Car car = new Car();

		boolean stop = false;

		while (!stop) {
			System.out.println("\n### Car Information System ###");
			System.out.println("1. Car Honk");
			System.out.println("2. Check Car Speed");
			System.out.println("3. Exit");
			System.out.print("chose from the options above: ");
			String option = sc.nextLine();

			switch (option) {
				case "1":
					System.out.println("Enter true or false to honk the car:");
					boolean isHonk = sc.nextBoolean();
					sc.nextLine();
					car.carHonk(isHonk);
					break;
				case "2":
					System.out.println("Enter the Speed of car");
					double speed = sc.nextDouble();
					sc.nextLine();
					System.out.println(car.carSpeed(speed));
					break;
				case "3":
					System.out.println("Exiting the program. Goodbye!");
					stop = true;
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		}
	}
}