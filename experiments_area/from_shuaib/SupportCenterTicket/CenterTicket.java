import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class CenterTicket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<String> line = new LinkedList<>();

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        String message = "Support Desk";
        int padding = 12;
        int totalWidth = 1 + padding + message.length() + padding + 1;

        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < totalWidth; col++) {
                if (col == 0 || col == totalWidth - 1) {
                    System.out.print("|");
                } else if (col <= padding) {
                    System.out.print(" ");
                } else if (col <= padding + message.length()) {
                    System.out.print(message.charAt(col - padding - 1));
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();

        System.out.print("Enter the number of actions you want to perform: ");
        int numActions = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numActions; i++) {
            for (int j = 0; j < menu.size(); j++) {
                System.out.println((j + 1) + " " + menu.get(j));
            }

            System.out.print("choose an option from above: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter the ticket:");
                    String ticket = sc.nextLine();
                    line.add(ticket);
                    break;

                case 2:
                    System.out.println("Enter the urgent ticket:");
                    String urgent = sc.nextLine();
                    Queue<String> tempQueue = new LinkedList<>();
                    tempQueue.add(urgent);

                    int currentSize = line.size();
                    for (int k = 0; k < currentSize; k++) {
                        tempQueue.add(line.poll());
                    }
                    line = tempQueue;
                    break;

                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        String served = line.poll();
                        System.out.println("Serving: " + served);
                    }
                    break;

                case 4:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        int viewSize = line.size();
                        Queue<String> tempQueue1 = new LinkedList<>();
                        for (int l = 0; l < viewSize; l++) {
                            String t = line.poll();
                            System.out.println((l + 1) + " " + t);
                            tempQueue1.add(t);
                        }
                        line = tempQueue1;
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        sc.close();
    }
}