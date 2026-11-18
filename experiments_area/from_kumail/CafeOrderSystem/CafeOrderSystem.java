
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class CafeOrderSystem {

    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        while (true) {

            System.out.print("\n> ");
            String chk = inp.nextLine().trim();

            if (chk.equals("quit")) {
                System.out.println("Program ended.");
                break;
            }

            if (chk.toLowerCase().startsWith("order ")) {

                String name = chk.substring(6).trim();

                if (name.isEmpty()) {
                    System.out.println("Please enter a customer name.");
                } else {
                    order(name);
                }

            } else if (chk.equalsIgnoreCase("serve")) {

                String cust = serve();

                if (cust == null) {
                    System.out.println(
                            "Cannot serve: the queue is already empty."
                    );
                } else {
                    System.out.println("Serving: " + cust);
                }

            } else {
                System.out.println("Invalid chk. Use order <name>, serve, or quit.");
            }

            if (queue.isEmpty()) {
                System.out.print("Queue is empty.");
            } else {
                System.out.print("Queue: " + queue);
            }

            System.out.println(" | Waiting: " + queue.size());
        }

        inp.close();
    }

    static void order(String name) {
        queue.offer(name);
    }

    static String serve() {

        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }
}
