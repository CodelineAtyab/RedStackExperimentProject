import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ticketQueue {
    static Queue<String> line = new LinkedList<>();


    public static void addTicket(String ticket) {
        line.add(ticket);
        System.out.println("Ticket added: " + ticket);
    }

    public static void addUrgentTicket(String ticket) {
        Queue<String> Templine = new LinkedList<>();
        Templine.add(ticket);
        for (String t : line) {
            Templine.add(t);
        }
        line = Templine;
        System.out.println("Urgent ticket added: " + ticket);
    }

    public static void serveNextTicket() {
        if (line.isEmpty()) {
            System.out.println("No tickets in the queue.");
        } else {
            String ticket = line.poll();
            System.out.println("Serving ticket: " + ticket);
        }
    }

    public static void viewWaitingTickets() {
        if (line.isEmpty()) {
            System.out.println("No tickets in the queue.");
        } else {
            System.out.println("Waiting tickets:");
            for (String ticket : line) {
                System.out.println(ticket);
            }
        }
    }

    public static void printBanner() {
    String currentMenu = "|                                    |";
    int totalLength = currentMenu.length();
    int availableSpace = totalLength - 2;

    String newTitle = "Support Desk";
    int totalSpacesCount = availableSpace - newTitle.length();
    int leftRightPaddingCount = totalSpacesCount / 2;

    System.out.print("|");
    for (int count=0; count<leftRightPaddingCount; count++) {
      System.out.print(" ");
    }
    System.out.print(newTitle);
    for (int count=0; count<leftRightPaddingCount; count++) {
      System.out.print(" ");
    }
    System.out.print("|");
    System.out.println();
    }



    public static void printMenu() {
    ArrayList<String> menu = new ArrayList<>();

    menu.add("Add ticket");
    menu.add("Add urgent ticket");
    menu.add("Serve next ticket");
    menu.add("View waiting tickets");
    
    for (int index=0; index<menu.size(); index++) {
      System.out.println(String.valueOf(index+1) + " " + menu.get(index));
    }
    }


    public static void main(String[] args) {
        printBanner();
        try (Scanner scanner = new Scanner(System.in)) {
            int action;
            System.out.println("Enter how many actions to perform: ");
            action = scanner.nextInt();
            for (int i = 0; i < action; i++) {
                printMenu();
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter ticket details: ");
                        scanner.nextLine(); 
                        String ticket = scanner.nextLine();
                        addTicket(ticket);
                        break;
                    case 2:
                        System.out.println("Enter urgent ticket details: ");
                        scanner.nextLine(); 
                        String urgentTicket = scanner.nextLine();
                        addUrgentTicket(urgentTicket);
                        break;
                    case 3:
                        serveNextTicket();
                        break;
                    case 4:
                        viewWaitingTickets();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

}
}