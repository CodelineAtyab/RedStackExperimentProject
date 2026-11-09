
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportCenterQueue {

    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);
        Queue<String> line = new LinkedList<>();

        // Print the banner
        String banner = "|                                    |";
        int totalLength = banner.length();
        int spaceAvailable = totalLength - 2;

        String bannerText = "Support Desk";
        int totalSpace = spaceAvailable - bannerText.length();
        int paddingLeftRight = totalSpace / 2;

        System.out.print("|");
        for (int i = 0; i < paddingLeftRight; i++) {
            System.out.print(" ");
        }
        System.out.print(bannerText);
        for (int i = 0; i < paddingLeftRight; i++) {
            System.out.print(" ");
        }

        System.out.print("|");
        System.out.println();

        // Create the menu
        ArrayList<String> menu = new ArrayList<>();

        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        // for (int i = 0; i < menu.size(); i++) {
        //     System.out.println((i + 1) + " " + menu.get(i));
        // }


        // Ask number of actions
        System.out.println("Enter number of actions you want to perform: ");
        int action = Integer.parseInt(inputBuffer.nextLine());

        // Repeat actions
        for (int i = 0; i < action; i++) {

            // Print menu again
            for (int j = 0; j < menu.size(); j++) {
                System.out.println((j + 1) + " " + menu.get(j));
            }
            // Read user's choice
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Add ticket: ");
                    String addTicket = inputBuffer.nextLine();
                    line.add(addTicket);
                    break;

                case 2:
                    System.out.print("Add urgent ticket: ");
                    String addUrgentTicket = inputBuffer.nextLine();
                    Queue<String> newLine = new LinkedList<>();
                    newLine.add(addUrgentTicket);

                    int size = line.size();
                    for(int r=0; r<size;r++){
                        newLine.add(line.poll());
                    }
                    line = newLine;
                    break;

                case 3:
                    if (line.isEmpty()){
                        System.out.println("No tickets waiting");
                    }else{
                        String servedTicket = line.poll();
                        System.out.println("Serving: " + servedTicket);
                    }
                    break;

                case 4:
                    if(line.isEmpty()){
                        System.out.println("No tickets waiting.");
                    }else{
                        int ticketSize = line.size();

                        for(int position = 1; position <= ticketSize; position++){
                            String ticket = line.poll();
                            System.out.println(position + " " + ticket);
                            line.add(ticket);
                        }
                    }
                    break;
            }
        }
        inputBuffer.close();
        
    }
}

 
