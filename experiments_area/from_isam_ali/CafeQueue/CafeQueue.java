import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class CafeQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Place order");
        menu.add("Serve next customer");
        menu.add("Exit");

        String banner = "Cafe Order";
        int width = 36;
        int leftover = width - banner.length();
        int leftpad = leftover / 2;
        int rightpad = leftover - leftpad;

        System.out.print("|");
        for (int i = 0; i < leftpad; i++) {
            System.out.print(" ");
        }
        System.out.print(banner);
        for (int i = 0; i < rightpad; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        int option;

        do {
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + " " + menu.get(i));
            }
            System.out.print("> ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.print("Customer name: ");
                    String name = sc.nextLine();
                    queue.add(name); 
                    break;
                }
                case 2: {
                    if (queue.isEmpty()) {
                        System.out.println("Cannot serve: the queue is already empty.");
                    } else {
                        String customer = queue.poll(); 
                        System.out.println("Serving: " + customer);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Goodbye!");
                    break;
                }
                default:
                    System.out.println("Invalid input");
            }

            if (option != 3) {
                String contents;
                if (queue.isEmpty()) {
                    contents = "Queue is empty.";
                } else {
                    contents = "Queue: " + queue; 
                }
                System.out.println(String.format("%-23s| Waiting: %d", contents, queue.size()));
                System.out.println();
            }
        } while (option != 3);
    }
}