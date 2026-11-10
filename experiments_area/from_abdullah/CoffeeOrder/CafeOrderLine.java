import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderLine {
    // In the LinkedList, the queue head is first and the tail is last.
    // offer() adds at the tail; poll() removes from the head.
    private Queue<String> queue = new LinkedList<>();

    public void order(String name) {
        queue.offer(name);
    }

    public String serveNext() {
        return queue.poll();
    }

    public int waitingCount() {
        return queue.size();
    }

    public String queueContents() {
        return queue.toString();
    }

    private void printStatus() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. | Waiting: 0");
        } else {
            System.out.println("Queue: " + queueContents()
                    + " | Waiting: " + waitingCount());
        }
    }

    public static void main(String[] args) {
        CafeOrderLine cafe = new CafeOrderLine();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("> ");

            if (!input.hasNextLine()) {
                break;
            }

            String command = input.nextLine().trim();

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.startsWith("order ")) {
                String name = command.substring(6).trim();

                if (name.isEmpty()) {
                    System.out.println("Please enter a customer name.");
                } else {
                    cafe.order(name);
                }

                cafe.printStatus();
            } else if (command.equalsIgnoreCase("serve")) {
                String name = cafe.serveNext();

                if (name == null) {
                    System.out.println(
                            "Cannot serve: the queue is already empty.");
                } else {
                    System.out.println("Serving: " + name);
                }

                cafe.printStatus();
            } else {
                System.out.println(
                        "Use 'order <name>', 'serve', or 'quit'.");
                cafe.printStatus();
            }
        }

        input.close();
    }
}