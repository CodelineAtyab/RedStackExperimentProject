import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class CafeOrderQueue {

    // The head represents the first customer to be served.
    // The tail represents the last customer waiting in line.
    final Queue<String> queue = new LinkedList<>();

    public void addCustomer(String name) {
        if (name != null && !name.isBlank()) {
            queue.offer(name);
        }
    }

    // Removes and returns the head of the queue, or null if the queue is empty.
    public String serveCustomer() {
        return queue.poll();
    }

    public int getWaitingCount() {
        return queue.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CafeOrderQueue cafe = new CafeOrderQueue();

        while (true) {

            System.out.print("Enter command: ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String command = scanner.nextLine().trim();

            if (command.isEmpty()) {
                continue;
            }

            String[] parts = command.split("\\s+", 2);

            if (parts[0].equalsIgnoreCase("order")) {

                if (parts.length == 2 && !parts[1].isBlank()) {
                    cafe.addCustomer(parts[1]);
                } else {
                    System.out.println("Please enter a customer name.");
                }

            } else if (parts[0].equalsIgnoreCase("serve")) {

                String served = cafe.serveCustomer();
                if (served == null) {
                    System.out.println("No customers to serve.");
                } else {
                    System.out.println("Served: " + served);
                }

            } else if (parts[0].equalsIgnoreCase("exit")) {

                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid command.");
            }

            System.out.println("Current queue: " + cafe.queue);
            System.out.println("Waiting customers: " + cafe.getWaitingCount());
        }

    }

}
