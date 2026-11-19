import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class CafeOrderLine {

    // Create a Queue using LinkedList
    private Queue<String> queue = new LinkedList<>();
    // Add a customer to the queue
    public void orderCustomer(String name) {
        queue.offer(name);// offer() --->adds the customer to the tail
    }

    public String serveCustomer() {  // Serve the first customer
        return queue.poll();// poll()--> removes the customer from the head
    }

        // Display the queue and waiting customer
        public void displayQueue() {

            if (queue.isEmpty()) {
                System.out.println("Queue is empty.        | Waiting: " + queue.size());
            } else {
                System.out.println("Queue: " + queue + " | Waiting: " + queue.size());
            }

            System.out.println();
        }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        CafeOrderLine cafe = new CafeOrderLine();
        while (true) {

            System.out.print("> ");
            String command = userInput.nextLine();
            if (command.startsWith("order ")) {
                String name = command.substring(6);// Get the customer name after "order "
                cafe.orderCustomer(name);

            } else if (command.equals("serve")) {

                
                String customer = cafe.serveCustomer();//serve first

                if (customer == null) {
                    System.out.println(
                        "Cannot serve: the queue is already empty."
                    );
                } else {
                    System.out.println("Serving: " + customer);
                }
            }
            cafe.displayQueue();// display the queue after every command
        }
    }
}
