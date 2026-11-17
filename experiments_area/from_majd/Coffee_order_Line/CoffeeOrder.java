import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoffeeOrder {

    static Queue<String> nameQueue = new LinkedList<>();
    static Scanner scInput = new Scanner(System.in);

    public static void main(String[] args) {

        String command;
        System.out.println("Welcome to the coffee order Program");

        
        while (true) {

            try{


System.out.print(">");

            command = scInput.nextLine();

            if (command == null || command.equals("exit"))
                break;

            else if (command.startsWith("order")) {
                nameQueue.offer(command.substring(6).trim()); //putting into the tail
                System.out.println("Queue:" + nameQueue + "  | Waiting: " + nameQueue.size() + "\n\n");

            }

            else if (command.startsWith("serve")) {

                String servedName;

                if (nameQueue.isEmpty()) {
                    System.out.println("Cannot serve: The Queue is already empty.");
                    System.out.println("Queue is empty: | Waiting: " + nameQueue.size() + "\n\n");



                } else if (nameQueue.size() == 1) {
                    servedName = nameQueue.poll(); //taking from the head
                    System.out.println(
                            "Serving: " + servedName + "\nQueue is empty: | Waiting: " + nameQueue.size() + "\n\n");


                }

                else {
                    servedName = nameQueue.poll();

                    System.out.println("Serving: " + servedName + "\nQueue: " + nameQueue
                            + "                                   | Waiting: " + nameQueue.size() + "\n\n");

                }

            }



            }catch(Exception error){

                System.out.println("not a valid command");
            }


            

        }
    }
};
