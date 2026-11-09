import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketQueue{
    public static void main ( String [] args){
        Queue<String> line = new LinkedList<>();
        ArrayList<String> menu = new ArrayList<>();
        Scanner inputBuffer = new Scanner(System.in);

        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add ("Serve next ticket");
        menu.add ("View waiting tickets");

        String titleFormat = "|                        |";
        int actualLength = titleFormat.length(); 
        int midLength = titleFormat.length()/2; 
        String title = "Support Desk";

        System.out.print(titleFormat.substring(0, midLength));
        System.out.print(title);
        System.out.println(titleFormat.substring(midLength, actualLength));
        
        System.out.println("enter number of actions you wanna preform ");
        int numberActions = Integer.parseInt(inputBuffer.nextLine());
        for (int n = 1 ; n<= numberActions ; n++){
            for (int i =0 ; i<menu.size() ; i++){
            System.out.println((i + 1) + " " + menu.get(i));
            }
            
            System.out.println("enter your choice ");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            if (choice == 1){
                System.out.println("enter ticket");
                String ticketN =  inputBuffer.nextLine();
                line.add(ticketN);
            }
            else if (choice == 2 ){
                System.out.println("enter ticket");
                String ticketN =  inputBuffer.nextLine();
                Queue <String> newLine = new LinkedList<>();
                newLine.add (ticketN);
                int oldSize = line.size();
                for (int q = 0 ; q < oldSize; q++){
                    newLine.add(line.poll());
                } 

                line = newLine;
            }
            
            else if (choice == 3) {
                if (line.isEmpty()){
                    System.out.println("No tickets found");
                }
                else{
                    System.out.println("Serving: "+ line.poll());
                }
            }

            else if (choice == 4){
                if (line.isEmpty()){
                    System.out.println("No tickets waiting");
                }
                else {
                    for (int q = 0 ; q < line.size(); q++){
                        String topTicket = line.poll();
                        System.out.println((q+1) + " " + topTicket);
                        line.add(topTicket);
                    }
                }
            }

        }

    }
}
