import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class CafeOrder {


    public static void main ( String [] args){


        // scanner to read from user
        Scanner sc = new Scanner(System.in);

        //create queue with linked list
        Queue <String> queue= new LinkedList<>();


        while (true) {

            System.out.print(" > ");
            String command = sc.nextLine();

            // check if comment start with order
            if (command.startsWith("order ")) {

                //here to get the name of customer
                String name = command.substring(6);

                // then add the name in tail of queue
                queue.offer(name);

            } else if (command.equals("serve")) {

                if (queue.isEmpty()) {
                    System.out.println("Cannot serve: the queue is already empty.");


                } else {

                    // Remove and serve the customer at the head of the queue>>> when use this the first name of customer is removed
                    System.out.println("Serving: " + queue.poll());
                }

            } else if (command.equals("quit")) {

                break;

            } else {
                System.out.println(" Invalid command.");
            }
            if (queue.isEmpty()) {
                System.out.println("Queue is empty. | Waiting: 0");
            } else {
                System.out.println("Queue: " + queue + " | Waiting: " + queue.size());
            }

            System.out.println();


        }


        sc.close();



    }






}
