import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderSystem {

    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();

        while (true) {
            System.out.print("enter order or serve: ");
            String choice = inputBuffer.nextLine().trim().toLowerCase();

            if (choice.equals("order")) {
                System.out.print("enter name: ");
                String name = inputBuffer.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Error: Name cannot be empty.");
                    System.out.println();
                } else {

                    queue.add(name);
                    System.out.println("order " + name);
                    System.out.println("Queue: " + queue + "           | Waiting: " + queue.size());
                    System.out.println();
                }

            } else if (choice.equals("serve")) {

                if (queue.isEmpty()) {
                    System.out.println("Cannot serve: the queue is already empty.");
                    System.out.println("Queue is empty.        | Waiting: 0");
                    System.out.println();
                } else {

                    String served = queue.poll();

                    System.out.println("Serving: " + served);

                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.        | Waiting: 0");
                    } else {
                        System.out.println("Queue: " + queue + "    | Waiting: " + queue.size());
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Invalid enter 'order'or 'serve' only.");
                System.out.println();
            }
        }
    }
}