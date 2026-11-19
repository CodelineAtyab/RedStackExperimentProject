import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CafeOrderLineSimulator {

    public static void main(String[] args) {
        // head: first customer,first out (served first)
        // tail: last customer in the queue (new customers join here)

        Queue<String> queue = new LinkedList<>();
        Scanner queueScanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Enter your command (order <name> / serve): ");
            String action = queueScanner.nextLine();

            if(action.startsWith("order ")){
                String customerName = action.substring(5).trim();

                if (!customerName.isEmpty()){
                    queue.offer(customerName);
                    System.out.println("Queue: "+queue+"           | Waiting: "+queue.size());
                } else{
                    System.out.println("Please enter a customer name.");
                    System.out.println("Queue: " + queue+ " | Waiting: " + queue.size());
                }
                
            } else if(action.equals("serve")){

                if (queue.isEmpty()){
                    System.out.println("Cannot serve: the queue is already empty.");
                    System.out.println("Queue is empty. | Waiting: " + queue.size());

                } else{

                    System.out.println("Serving: "+queue.poll());
                    if(queue.isEmpty()){
                        System.out.println("Queue is empty. | Waiting: " + queue.size());
                    }else{
                        System.out.println("Queue: "+queue+"           | Waiting: "+queue.size());
                    }  
                }

            } else{
                System.out.println("exit");
                run = false;
            } 
        }
        
    }
}