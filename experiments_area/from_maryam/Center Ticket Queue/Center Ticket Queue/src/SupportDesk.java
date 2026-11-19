
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class SupportDesk {

    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);
        Queue<String> line = new LinkedList<>();

        ArrayList<String> menu = new ArrayList<>();

        // print the menu
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        //print a title with space like the evaluation question
        String title = "Support Desk";
        int space = (36 - title.length()) / 2;

        System.out.print("|");

        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }

        System.out.print(title);

        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }

        System.out.println("|");

        System.out.println("How many actions do you want to perform?");
        //read the number of action
        int actions = Integer.parseInt(inputBuffer.nextLine());

        // repeat the menu depend on the number of action we select
        for (int i = 0; i < actions; i++) {

            // display menu options
            for (int j = 0; j < menu.size(); j++) {
                System.out.println((j + 1) + " " + menu.get(j));
            }

            // read what user is choice
            System.out.println("Choose an option:");
            int choice = Integer.parseInt(inputBuffer.nextLine());

            if (choice == 1) {

                System.out.println("Enter ticket:");

                String ticket = inputBuffer.nextLine();

                line.add(ticket)
                ;

            } else if (choice == 2) {

                System.out.println("Enter urgent ticket:");

                String ticket = inputBuffer.nextLine();


                //create a new queue and add urgent ticket first
                Queue<String> newLine = new LinkedList<>();
                newLine.add(ticket);

                // it means move old tickets to the new queue
                int size = line.size();

                for (int j = 0; j < size; j++) {

                    //removes and returns the front item (returns null if the line is empty)
                    newLine.add(line.poll());
                }

                line = newLine;

            } else if (choice == 3) {

                //true if nothing is waiting
                if (line.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {
                    System.out.println("Serving: " + line.poll());
                }

            } else if (choice == 4) {

                if (line.isEmpty()) {
                    System.out.println("No tickets waiting");
                } else {

                    //how many items are in the line
                    int size = line.size();

                    for (int j = 0; j < size; j++) {

                        //returns the front item without removing it (null if empty)
                        String ticket = line.poll();

                        // print ticket position and text
                        System.out.println((j + 1) + " " + ticket);

                        //puts an item at the back of the line
                        line.add(ticket);
                    }
                }
            }
        }

        inputBuffer.close();
    }
}
