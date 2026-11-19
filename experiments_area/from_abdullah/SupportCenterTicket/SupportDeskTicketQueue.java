import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportDeskTicketQueue {
    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        Queue<String> line = new LinkedList<>();

        // 1. Banner: a 40-character line with the title centred between two borders
        String title = "Support Desk";
        int width = 40;
        int innerWidth = width - 2; // space between the two "|" borders
        int leftSpaces = (innerWidth - title.length()) / 2;
        int rightSpaces = innerWidth - title.length() - leftSpaces;

        System.out.print("|");
        for (int i = 0; i < leftSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        for (int i = 0; i < rightSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        // 2. Menu items
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        // 3. Read how many actions, then repeat the menu that many times
        int actions = Integer.parseInt(inputBuffer.nextLine());

        for (int round = 0; round < actions; round++) {
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + " " + menu.get(i));
            }

            int choice = Integer.parseInt(inputBuffer.nextLine());

            if (choice == 1) {
                // 4. Add ticket at the back
                String ticket = inputBuffer.nextLine();
                line.add(ticket);
                System.out.println("Ticket added successfully");

            } else if (choice == 2) {
                // 5. Add urgent ticket at the front by rebuilding the queue
                String ticket = inputBuffer.nextLine();
                Queue<String> newLine = new LinkedList<>();
                newLine.add(ticket);
                int oldSize = line.size();
                for (int i = 0; i < oldSize; i++) {
                    newLine.add(line.poll());
                }
                line = newLine;
                System.out.println("Urgent ticket added successfully");

            } else if (choice == 3) {
                // 6. Serve the next ticket
                if (line.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {
                    System.out.println("Serving: " + line.poll());
                }

            } else if (choice == 4) {
                // 7. View tickets without changing the order
                if (line.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {
                    int size = line.size();
                    for (int i = 0; i < size; i++) {
                        String ticket = line.poll();
                        System.out.println((i + 1) + " " + ticket);
                        line.add(ticket);
                    }
                }
            }
        }
    }
}