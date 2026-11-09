import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketQueue {

    static Scanner inputBuffer = new Scanner(System.in);

    public static void main(String[] args) {

        String titleMenu = "|                                  |";
        int totalLength = titleMenu.length();
        int availableSpace = totalLength - 2;

        String currentTitle = "Support Desk";
        int totalSpace = availableSpace - currentTitle.length();
        int PaddingCount = totalSpace / 2;

        System.out.print("|");

        for (int count = 0; count < PaddingCount; count++) {
            System.out.print(" ");
        }

        System.out.print(currentTitle);

        for (int count = 0; count < PaddingCount; count++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");
          
        for (int orderMenu = 0; orderMenu < menu.size(); orderMenu++) {
            System.out.println((orderMenu + 1) + " " + menu.get(orderMenu));
        }

        System.out.println("enter a number actions to perform : ");
        int action = Integer.parseInt(inputBuffer.nextLine());
        Queue<String> line = new LinkedList<>();

        for (int repeate = 0; repeate < action; repeate++) {
            
            System.out.println("choice number : ");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("ticket : ");
                    String addTicket = inputBuffer.nextLine();
                    line.add(addTicket);
                    break;

                case 2:
                    System.out.println("urgent Ticket: ");
                    String urgentTicket = inputBuffer.nextLine();

                    Queue<String> urgentTicketQueue = new LinkedList<>();
                    urgentTicketQueue.add(urgentTicket);

                    int oldSize = line.size();
                    for (int i = 0; i < oldSize; i++) {
                        urgentTicketQueue.add(line.poll());
                    }

                    line = urgentTicketQueue;
                    break;

                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting.");
                    } else {
                        String nextTicket = line.peek(); // review who is next
                        System.out.println("Serving: " + nextTicket);
                        line.poll();
                    }
                    break;

                case 4:
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
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        inputBuffer.close();
    }
}