import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportCenterTicketQueue {
    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        String title = "Support Desk";
        int bannerLength = 34;
        int spaces = ((bannerLength - title.length() - 2) / 2);

        System.out.print("|");
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        // menu items
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("Add ticket");
        menuItems.add("Add urgent ticket");
        menuItems.add("Serve next ticket");
        menuItems.add("View waiting tickets");

        // the waiting line
        Queue<String> line = new LinkedList<>();

        int numberOfActions = Integer.parseInt(inputBuffer.nextLine());

        for (int i = 0; i < numberOfActions; i++) {

// printing menu
            for (int j = 0; j < menuItems.size(); j++) {
                System.out.println((j + 1) + " " + menuItems.get(j));
            }
            System.out.print("Choice: ");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket: ");
                    String ticket = inputBuffer.nextLine();
                    line.add(ticket);
                    break;

                case 2:
                    System.out.print("Enter Urgent Ticket: ");
                    String urgentTicket = inputBuffer.nextLine();
                    Queue<String> newLine = new LinkedList<>();
                    newLine.add(urgentTicket);

                    int oldLineSize = line.size();
                    for (int v = 0; v < oldLineSize; v++) {
                        newLine.add(line.poll());
                    }

                    line = newLine;
                    break;

                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        System.out.println("Serving: " + line.poll());
                    }
                    break;

                case 4:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        int waitingCount = line.size();
                        for (int v = 0; v < waitingCount; v++) {
                            String waitingTicket = line.poll();
                            System.out.println((v + 1) + " " + waitingTicket);
                            line.add(waitingTicket);
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        inputBuffer.close();
    }
}