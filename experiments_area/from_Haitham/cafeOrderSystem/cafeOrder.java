import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cafeOrder{
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
        String input = sc.nextLine();
        if (input.equals("0")) 
            {
                break;
            }
        if(input.startsWith("order"))
            {
            String name = input.substring(6);
            queue.add(name);
            System.out.println("queue: "+queue+" | Waiting: " + queue.size());
            }
        else if(input.startsWith("serve"))
            {
            if(!queue.isEmpty())
            {
                String popname = queue.poll();
                System.out.println("Serving: " + popname+" | Waiting: " + queue.size());
            }
            else {
            System.out.println("Cannot serve: the queue is already empty.");
            System.out.println("Queue is empty." +" | Waiting: " + queue.size());
                }
            }        
        }
    sc.close();
    }
}