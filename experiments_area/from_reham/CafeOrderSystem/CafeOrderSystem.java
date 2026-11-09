import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        while(true){
        System.out.print("Enter Your Command: Order / serve / quit ");
        String command = input.nextLine().toLowerCase();
        if(command.equals("quit")){
            break;
        }
        if(command.startsWith("order")){
            String name = command.substring(6);
            queue.add(name);
            System.out.println("> order "+name);
            System.out.println("Queue: "+ queue + "             | Waiting : "+queue.size());
        }
        if (command.startsWith("serve")){
            if (!queue.isEmpty()){
                String Serve= queue.poll();
                System.out.println("> serve");
                System.out.println("Serving: "+Serve +"\nQueue: "+queue+"           |Waiting: "+queue.size());
            }
            else{
                System.out.println("> serve\nCannot serve: the queue is already empty. ");
                System.out.println("Queue is empty.         Witing: "+queue.size());
            }
             
        }
        
        
        }
    }
}
