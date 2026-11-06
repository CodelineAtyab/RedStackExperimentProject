import java.io.IOException;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportCenterTicket{
    static Scanner input = new Scanner(System.in);
    static Queue<String> line = new LinkedList<>();
    static Queue<String> Uline = new LinkedList<>();

    public static void main(String[] args) {
        //Waiting line 
        banner();
        boolean running =true;
        
        while (running==true){
            try{
                menu();
                System.out.print("\nEnter A number: ");
                int choice = input.nextInt();
                switch (choice){
                    case 1:addTicket();break;
                    case 2:AddUrgentTicket();break;
                    case 3:ServeNextTicket();break;
                    case 4:WaitingTickets();break;
                    default:System.out.println("Invalid Choice");running=false;break;
                }
            }catch(InputMismatchException exception){
                System.out.println(" Enter a valid number!");
                input.nextLine();

            }
        }
    }

    public static void banner(){
    
        String name = "Support Desk";
        System.out.print("|  ");
        for (int i=0 ; i<name.length();i++){
            System.out.print(" ");
        }
        System.out.print(name);
         for (int i=0 ; i<name.length();i++){
            System.out.print(" ");
        }
        System.out.println("|  \n");
    }

    public static void menu(){
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        for (int i=0 ; i<menu.size();i++){
            System.out.println((i+1)+". "+ menu.get(i));
        }
    }
    
    public static void addTicket(){
        System.out.print("Enter Your Ticket: ");
        input.nextLine();
        String Ticket =input.nextLine();
        line.add(Ticket);
        if (line.contains(Ticket)){
            System.out.println("Your Ticket is added Sucsesflly");

        }else{
            System.out.println("Error!");
        }
    }

    public static void AddUrgentTicket(){

        System.out.print("Enter your urgent Ticket: ");
        input.nextLine();
        String UTicket =input.nextLine();
        Uline.add(UTicket);
        int size = line.size();
        for (int i=0 ; i<size ; i++){
            String ticket =line.poll();
            Uline.add(ticket);
        }
        if (Uline.contains(UTicket)){
            System.out.println("Added Sucsesflly");
            line=Uline;

        }
        System.out.println(Uline);
    }

    public static void ServeNextTicket(){
        if (line.isEmpty()){
            System.out.println("No Tickets Waiting");
        }else{
            System.out.println("Serving: "+line.poll());
            }
    }

    public static void WaitingTickets(){
        int waWaitingTicketsCount=line.size();
        for(int i=0 ; i<waWaitingTicketsCount ;i++){
            String waWaitingTickets= line.poll();
            System.out.println((i+1)+" "+waWaitingTickets);
            line.add(waWaitingTickets);
            

        }
    }
    
}
