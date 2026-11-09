import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SupportTicket{

    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);

        // Print the banner
        String banner = "|           Support Desk            |";
       System.out.println(banner);

        // Store menu items in array list 
            ArrayList<String> Items = new ArrayList<>();

                 Items.add("Add ticket");
                 Items.add("Add urgent ticket");
                 Items.add("Serve next ticket");
                 Items.add("View waiting tickets");

        // Store waiting tickets
             Queue<String> q = new LinkedList<>();

                //num of action
             int number = Integer.parseInt(userInput.nextLine());
        for (int i = 0; i < number; i++) {
            // Print the menu
            for (int j = 0; j < Items.size(); j++) {
                System.out.println((j + 1) + " " + Items.get(j));
            }


            int choice = Integer.parseInt(userInput.nextLine());
            // Add normal ticket
            if (choice == 1) {
                String ticket = userInput.nextLine();
                q.add(ticket);
            }

            // Add urgent ticket
            else if (choice == 2) {
                String ticket = userInput.nextLine();
                Queue<String> newLine = new LinkedList<>();
                // Add urgent ticket first
                newLine.add(ticket);
                int oldSize = q.size();
                for (int j = 0; j < oldSize; j++) {
                    String oldTicket = q.poll();
                    newLine.add(oldTicket);
                }
                q = newLine;
            }

            // Serve next ticket
            else if (choice == 3) {
                if (q.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {
                    String ticket = q.peek();//llok the first ticket without removing 
                    System.out.println("Serving: " + ticket);
                    q.poll();//remove from the queue
                }
            }

            // View waiting tickets
            else if (choice == 4) {
                if (q.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        String ticket = q.poll();
                        System.out.println((j + 1) + " " + ticket);
                        q.add(ticket);
                    }
                }
            }
        }

        userInput.close();
    }
}
