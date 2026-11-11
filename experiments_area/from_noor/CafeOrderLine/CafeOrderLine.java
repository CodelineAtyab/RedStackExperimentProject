package CafeOrderLine;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CafeOrderLine {

    public static void main(String[] args) {
        
  Scanner input = new Scanner(System.in);
  Queue<String> queue = new LinkedList<>();

while (true) {

            System.out.print("> ");
            String command = input.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                break;
            }
   ///////////////////////////////////////


            if (command.startsWith("order ")) {

                String customerName = command.substring(6).trim();

                if (customerName.isEmpty()) {
                    System.out.println("Please enter a customer name.");
                } else {
                    queue.add(customerName);
                }

            } else if (command.equalsIgnoreCase("serve")) {

                if (queue.isEmpty()) {
                    System.out.println(
                        "Cannot serve: the queue is already empty."
                    );
                } else {
                    String customer = queue.poll();
                    System.out.println("Serving: " + customer);
                }

            } else {
                System.out.println("Invalid command.");
            }


   ///////////////////////////////////////



            if (queue.isEmpty()) {
                System.out.println("Queue is empty. | Waiting: 0");
            } else {
                System.out.println(
                    "Queue: " + queue + " | Waiting: " + queue.size()
                );
            }
        }

        input.close();
    }
}

