
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerService {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Required queue
        Queue<String> line = new LinkedList<>();

        // Menu items
        ArrayList<String> menu = new ArrayList<>();

        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        // Display program title
        String title = "Support Desk";
        int spaces = (36 - title.length()) / 2;

        System.out.print("|");

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        System.out.print(title);

        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }

        System.out.println("|");

        // Ask number of actions
        System.out.print("How many actions? ");
        int actions = Integer.parseInt(input.nextLine());

        // Repeat menu for the number of actions
        for (int i = 0; i < actions; i++) {

            System.out.println("\nMenu:");

            // Display menu
            for (int j = 0; j < menu.size(); j++) {
                System.out.println((j + 1) + " " + menu.get(j));
            }

            System.out.print("Enter your choice: ");
            String choiceText = input.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            // Add normal ticket
            if (choice == 1) {

                System.out.print("Enter ticket description: ");
                String ticket = input.nextLine();

                if (ticket.isEmpty()) {
                    System.out.println("Tickets cannot be empty.");
                } else {
                    line.add(ticket);
                    System.out.println("Ticket added successfully.");
                }
            }

            // Add urgent ticket
            else if (choice == 2) {

                System.out.print("Enter urgent ticket: ");
                String ticket = input.nextLine();

                if (ticket.isEmpty()) {
                    System.out.println("Ticket cannot be empty.");
                } else {

                    Queue<String> temp = new LinkedList<>();

                    temp.add("URGENT: " + ticket);

                    int size = line.size();

                    for (int j = 0; j < size; j++) {
                        temp.add(line.poll());
                    }

                    line = temp;

                    System.out.println("Urgent ticket added to the front.");
                }
            }

            // Serve next ticket
            else if (choice == 3) {

                if (line.isEmpty()) {
                    System.out.println("No tickets waiting.");
                } else {
                    String ticket = line.poll();
                    System.out.println("Serving: " + ticket);
                }
            }

            // View waiting tickets
            else if (choice == 4) {

                if (line.isEmpty()) {
                    System.out.println("No tickets waiting.");
                } else {

                    int size = line.size();

                    for (int j = 0; j < size; j++) {

                        String ticket = line.poll();

                        System.out.println((j + 1) + " " + ticket);

                        line.add(ticket);
                    }
                }
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
