
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class SupportTicketQueue {

    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);
        Queue<String> line = new LinkedList<>();
        ArrayList<String> menuItems = new ArrayList<>();

        menuItems.add("Add ticket");
        menuItems.add("Add urgent ticket");
        menuItems.add("Serve next ticket");
        menuItems.add("View waiting tickets");

      
        String title = "Support Desk";   // Print banner
        int titleLength = title.length();
        int spaces = (36 - titleLength) / 2;

        System.out.print("|");
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.println("|");


    
    
       
        for (int i = 0; i < menuItems.size(); i++) {   // menu
            System.out.println((i + 1) + " " + menuItems.get(i));
        } 

        System.out.println("How many actions?");
        int actions = Integer.parseInt(inputBuffer.nextLine());

        for (int j = 0; j < actions; j++) {

            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + " " + menuItems.get(i));
            }




            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter ticket: ");
                    String ticket = inputBuffer.nextLine();

                    line.add(ticket);
                    break;

                case 2:
                    System.out.print("Enter urgent ticket: ");
                    String urgentTicket = inputBuffer.nextLine();

                    Queue<String> newLine = new LinkedList<>();

                    newLine.add(urgentTicket);

                    int oldSize = line.size();

                    for (int i = 0; i < oldSize; i++) {
                        newLine.add(line.poll());
                    }

                    line = newLine;
                    break;

                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting.");
                    } else {
                        String servedTicket = line.poll();

                        System.out.println("Serving: " + servedTicket);
                    }
                    break;

                case 4:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting.");
                    } else {
                        int size = line.size();

                        for (int i = 0; i < size; i++) {
                            String waitingTicket = line.poll();

                            System.out.println((i + 1) + " " + waitingTicket);

                            line.add(waitingTicket);
                        }
                    }
                    break;
            }
        }

        inputBuffer.close();
    }
}
