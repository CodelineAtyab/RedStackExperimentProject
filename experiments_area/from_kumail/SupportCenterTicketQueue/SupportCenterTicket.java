import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportCenterTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> line = new LinkedList<>();
        ArrayList<String> menu = new ArrayList<>();

        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        String title = "Support Desk";
        int w = 36;
        int s = (w - title.length()) / 2;

        System.out.println("+------------------------------------+");
        System.out.print("|");

        for (int i = 0; i < s; i++) {
            System.out.print(" ");
        }
        System.out.print(title);

        for (int i = 0; i < s; i++) {
            System.out.print(" ");
        }
        System.out.println(" |");
        System.out.println("+------------------------------------+");

        System.out.print("How many actions? ");
        int action = Integer.parseInt(input.nextLine());

        for (int i = 0; i < action; i++) {
            for (int j = 0;j < menu.size(); j++ ){
                System.out.println((j + 1) + " " + menu.get(j));
            }
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket: ");
                    String ticket = input.nextLine();
                    line.add(ticket);
                    break;
                case 2:
                    System.out.print("Enter urgent ticket: ");
                    String urgTick = input.nextLine();

                    Queue<String> newLine = new LinkedList<>();

                    newLine.add(urgTick);

                    int oldSize = line.size();

                    for (int j = 0; j < oldSize; j++) {
                        String oldTick = line.poll();
                        newLine.add(oldTick);
                    }

                    line = newLine;
                    break;
                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        String servTick = line.poll();
                        System.out.println("Serving: " + servTick);
                    }
                    break;
                case 4:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        int size = line.size();

                        for (int j = 0; j < size; j++) {
                            String waitTick = line.poll();

                            System.out.println((j + 1) + " " + waitTick);

                            line.add(waitTick);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
