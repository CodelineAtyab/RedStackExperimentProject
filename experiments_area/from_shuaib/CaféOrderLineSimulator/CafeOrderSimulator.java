import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderSimulator {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner inputBuffer = new Scanner(System.in);

        System.out.println("=== Café Order-Line Simulator ===");

        while (true) {
            System.out.println("\nAvailable commands: order <name>  |  serve  |  quit");

            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting simulator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}