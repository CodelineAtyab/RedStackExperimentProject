import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class supportCenterTicket {

    static Queue<String> ticketQueue = new LinkedList<>();
    static Scanner scInput = new Scanner(System.in);
    static Queue<String> QLine = new LinkedList<>();

    static void updateMenuTitle(String title) {

        System.out.print("|" + " ".repeat(title.length()));
        System.out.print(title);
        System.out.print(" ".repeat(title.length()) + "|");

        System.out.println();
        System.out.println();

    }

    static void printMenu() {
System.out.println("\n");
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Add Ticket");
        menuOptions.add("Add urgent Ticket");
        menuOptions.add("Serve next Ticket");
        menuOptions.add("View waiting Tickets");

        for (int i = 0; i < menuOptions.size(); i++)
            System.out.println((i + 1) + ". " + menuOptions.get(i));

    }

    static void AddTicket() {

        String readTicket;

        System.out.print("Enter Ticket: ");
        readTicket = scInput.nextLine();

        QLine.add(readTicket);

    }

    static void AddUrgentTicket() {

        String readUrgentTicket;
        Queue<String> urgentTicketQueue = new LinkedList<>();

        System.out.print("Enter Urgent Ticket: ");
        readUrgentTicket = scInput.nextLine();

        urgentTicketQueue.add(readUrgentTicket);

        int Line = QLine.size();
        for (int i = 0; i < Line; i++) {
            urgentTicketQueue.add(QLine.poll());
        }

        QLine = urgentTicketQueue;

    }

    static void serveNextTicket() {

        if (QLine.isEmpty()) {
            System.out.println("No tickets in the queue.");
        } else {
            String servedTicket = QLine.poll();
            System.out.println("Serving Ticket: " + servedTicket);
        }

    }

    static void viewWaitingTickets() {

        if (QLine.isEmpty()) {
            System.out.println("No tickets in the queue.");
        } else {
            System.out.println("Waiting Tickets:");
            for (String ticket : QLine) {
                System.out.println(ticket);
            }
        }

    }

    static void program() {
        updateMenuTitle("SUPPORT DESK");

        int actionCount = 0;

        System.out.println("How many actions do you want to perform?: ");

        actionCount = scInput.nextInt();
        scInput.nextLine();
        for (int i = 0; i < actionCount; i++) {


            printMenu();
            System.out.print("Choose: ");

            short choice = 0;

            choice = scInput.nextShort();
            scInput.nextLine();

            switch (choice) {

                case 1:
                    AddTicket();
                    break;

                case 2:
                    AddUrgentTicket();
                    break;

                case 3:
                    serveNextTicket();
                    break;

                case 4:
                    viewWaitingTickets();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }

    public static void main(String[] args) {

        program();

    }

}