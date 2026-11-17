import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

    public class CafeOrderSystem {
        private final Queue<String> queue = new LinkedList<>();

        public void order(String name) {
            queue.offer(name); // Add customer to the tail (end) of the queue
        }

        public String serve() {
            String customer = queue.poll(); // Remove customer from the head (front) of the queue
            return customer == null
                    ? "Cannot serve: the queue is already empty."
                    : "Serving: " + customer;
        }

        public String queueStatus() {
            if (queue.isEmpty()) {
                return "Queue is empty. | Waiting: 0";
            }
            return "Queue: " + queue + " | Waiting: " + queue.size();
        }

        public static void main(String[] args) {
            CafeOrderSystem cafe = new CafeOrderSystem();

            System.out.println("Commands: order <name>, serve, quit");

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("> ");
                    if (!scanner.hasNextLine()) {
                        break;
                    }

                    String input = scanner.nextLine().trim();
                    if (input.equalsIgnoreCase("quit")) {
                        break;
                    }

                    if (input.equalsIgnoreCase("serve")) {
                        System.out.println(cafe.serve());
                    } else if (input.regionMatches(true, 0, "order ", 0, 6)) {
                        String name = input.substring(6).trim();
                        if (name.isEmpty()) {
                            System.out.println("Please provide a customer name.");
                        } else {
                            cafe.order(name);
                        }
                    } else {
                        System.out.println("Unknown command. Use order <name>, serve, or quit.");
                    }

                    System.out.println(cafe.queueStatus());
                    System.out.println();
                }
            }
        }
    }
