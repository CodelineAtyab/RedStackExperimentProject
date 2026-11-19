import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderSystem {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter > ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String input = scanner.nextLine();
                if (input.regionMatches(true, 0, "order ", 0, 6)) {
                    String name = input.substring(6).trim();
                    if (name.isEmpty()) {
                        System.out.println("Please provide a customer name.");
                    } else {
                        queue.offer(name); // Add at the tail.
                    }
                } else if (input.equalsIgnoreCase("serve")) {
                    String customer = queue.poll(); // Remove from the head.
                    if (customer == null) {
                        System.out.println("Cannot serve: the queue is already empty.");
                    } else {
                        System.out.println("Serving: " + customer);
                    }
                } else {
                    System.out.println("Unknown command. Use 'order <name>', 'serve', or 'quit'.");
                }

                if (queue.isEmpty()) {
                    System.out.println("Queue is empty. | Waiting: 0");
                } else {
                    System.out.println("Queue: " + queue + " | Waiting: " + queue.size());
                }
                System.out.println();
            }
        }
    }
}