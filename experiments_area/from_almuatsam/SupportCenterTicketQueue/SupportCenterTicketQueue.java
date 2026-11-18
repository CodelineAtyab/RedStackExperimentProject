import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportCenterTicketQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("Add normal ticket");
        menuItems.add("Add urgent ticket");
        menuItems.add("Serve next ticket");
        menuItems.add("View waiting tickets");

        Queue<String> line = new LinkedList<>();

        String title = "SUPPORT CENTER TICKET QUEUE";
        int screenWidth = 60;
        int padding = (screenWidth - title.length()) / 2;
        String spaces = "";
        for (int i = 0; i < padding; i++) {
            spaces += " ";
        }
        System.out.println(spaces + title);

        System.out.println("How many actions do you want to perform?");
        int actions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < actions; i++) {
            for (int j = 0; j < menuItems.size(); j++) {
                System.out.println((j + 1) + ". " + menuItems.get(j));
            }

            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.println("Enter ticket description:");
                String description = scanner.nextLine();
                line.add(description);
            } else if (choice == 2) {
                System.out.println("Enter ticket description:");
                String description = scanner.nextLine();
                ((LinkedList<String>) line).addFirst(description);
            } else if (choice == 3) {
                if (line.isEmpty()) {
                    System.out.println("No tickets to serve");
                } else {
                    String served = line.poll();
                    System.out.println("Serving ticket: " + served);
                }
            } else if (choice == 4) {
                if (line.isEmpty()) {
                    System.out.println("No waiting tickets");
                } else {
                    LinkedList<String> linkedLine = (LinkedList<String>) line;
                    ArrayList<String> tickets = new ArrayList<>();

                    for (int outer = 0; outer < linkedLine.size(); outer++) {
                        for (int inner = 0; inner < linkedLine.size(); inner++) {
                            if (inner == outer) {
                                tickets.add(linkedLine.get(inner));
                            }
                        }
                    }

                    for (int k = 0; k < tickets.size(); k++) {
                        System.out.println((k + 1) + ". " + tickets.get(k));
                    }
                }
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
