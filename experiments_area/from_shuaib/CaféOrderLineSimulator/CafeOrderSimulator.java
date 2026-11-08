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
            else if (input.equalsIgnoreCase("serve")) {
                if (queue.isEmpty()) {
                    System.out.println("Cannot serve: the queue is already empty.");
                } else {
                    System.out.println("Serving: " + queue.poll());
                }
            }
            else if (input.toLowerCase().startsWith("order ")) {
                String name = input.substring(6).trim();
                if (!name.isEmpty()) {
                    queue.offer(name);
                } else {
                    System.out.println("Invalid name. Usage: order <name>");
                    continue;
                }
            }
        }

        scanner.close();
    }
}