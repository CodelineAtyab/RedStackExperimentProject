
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrder{

    // Create a Queue using LinkedList
    private Queue<String> queue = new LinkedList<>();

    // Add a customer to the queue
    public void orderCustomer(String name) {
        queue.offer(name);
    }

    // Serve the first customer
    public String serveCustomer() {
        return queue.poll();
    }

    // Display the queue and waiting customers
    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty | Waiting: " + queue.size());
        } else {
            System.out.println("Queue: " + queue + " | Waiting: " + queue.size());
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        CafeOrder cafe = new CafeOrder();

        while (true) {

            System.out.print("> ");
            String command = userInput.nextLine();

            if (command.startsWith("order ")) {

                String name = command.substring(6);
                cafe.orderCustomer(name);

            } else if (command.equals("serve")) {

                String customer = cafe.serveCustomer();

                if (customer == null) {
                    System.out.println(
                        "Cannot serve: the queue is already empty."
                    );
                } else {
                    System.out.println("Serving: " + customer);
                }

            } else if (command.equals("exit")) {
                System.out.println("Cafe order system closed.");
                break;
            }

            cafe.displayQueue();
        }

        userInput.close();
    }
}
