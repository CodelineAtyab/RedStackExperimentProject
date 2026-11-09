
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class SupportCenterTicket {
    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);

        Queue<String> line = new LinkedList<>();

        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("Add Ticket");
        menuItems.add("Add Urgent Ticket");
        menuItems.add("Serve Next Ticket");
        menuItems.add("View Waiting Tickets");

        // Display the Support Desk title
        String menuTitle = "Support Desk";
        int bannerWidth = 36;
        int remainingSpaces = bannerWidth - menuTitle.length();
        int leftSpaces = remainingSpaces / 2;
        int rightSpaces = remainingSpaces - leftSpaces;

        System.out.println("+------------------------------------+");
        System.out.print("|");

        for (int i = 0; i < leftSpaces; i++) {
            System.out.print(" ");
        }

        System.out.print(menuTitle);

        for (int i = 0; i < rightSpaces; i++) {
            System.out.print(" ");
        }

        System.out.println("|");
        System.out.println("+------------------------------------+");

        // Ask how many actions to perform
        System.out.print("How Many Actions? ");
        int totalActions = Integer.parseInt(inputBuffer.nextLine());
        System.out.println();

        for (int actionNumber = 0; actionNumber < totalActions; actionNumber++) {

            // Display the numbered menu
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + " " + menuItems.get(i));
            }
            System.out.println();

            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(inputBuffer.nextLine());
            System.out.println();

            switch (choice) {

                case 1: {
                    // Add a normal ticket to the back
                    System.out.print("Describe the Issue: ");
                    String ticketText = inputBuffer.nextLine();

                    line.add(ticketText);
                    System.out.println();
                    break;
                }

                case 2: {
                    // Add an urgent ticket to the front
                    System.out.print("Describe the Urgent Issue: ");
                    String urgentIssue = inputBuffer.nextLine();

                    Queue<String> priorityLine = new LinkedList<>();
                    priorityLine.add(urgentIssue);

                    // Move existing tickets behind the urgent one
                    int waitingCount = line.size();

                    for (int i = 0; i < waitingCount; i++) {
                        String previousTicket = line.poll();
                        priorityLine.add(previousTicket);
                    }
                    line = priorityLine;
                    System.out.println();
                    break;
                }

                case 3: {
                    // Serve the first ticket in the queue
                    if (line.isEmpty()) {
                        System.out.println("No Tickets Waiting");
                    } else {
                        String currentTicket = line.poll();
                        System.out.println("Serving: " + currentTicket);
                    }
                    System.out.println();
                    break;
                }

                case 4: {
                    // Display tickets without changing their order
                    if (line.isEmpty()) {
                        System.out.println("No Tickets Waiting");
                    } else {
                        int currentTicketCount = line.size();

                        for (int i = 0; i < currentTicketCount; i++) {
                            String currentTicket = line.poll();
                            System.out.println((i + 1) + " " + currentTicket);
                            line.add(currentTicket);
                        }
                    }
                    System.out.println();
                    break;
                }
                default:
                    System.out.println("Invalid Choice");
            }
        }
        inputBuffer.close();
    }
}
