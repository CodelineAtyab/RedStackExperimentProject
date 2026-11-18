import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cafeQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>(); // to store the customers name input 
        
        while (true){
            System.out.println("enter q to exit: ");
            System.out.print("> ");
            String input = scanner.nextLine(); // taking the input from the user
            String name;  // to store the name of the customer

            if (input.equals("serve")) {
                if (queue.isEmpty()) {
                    System.out.print("Queue is empty            |");
                    System.out.println("waiting: "+ queue.size());
                }
                else{
                    System.out.println("Serving: "+queue.poll());// serving the cutomer that the head is pointing at which is the first index  in the queue
                    System.out.print(queue+"               |  "); //printing all the customers in the queue
                    System.out.println("waiting: "+ queue.size()); //printing the size of the queue ---> refers to how many are waiting
                }
            }
            else if (input.startsWith("order")) {
            name = input.substring(5); // it goes from the 5th index to the end of the string
            queue.add (name); // adding the name to the tail (end of the queue)

            System.out.print(queue+"               |  "); //printing all the customers in the queue
            System.out.println("waiting: "+ queue.size()); //printing the size of the queue ---> refers to how many are waiting
            }
            
            else if (input.equals("q")) {
                break;
            }

            else{
                    System.out.println("Invalid input");
            }
                
        }
        
    }
}