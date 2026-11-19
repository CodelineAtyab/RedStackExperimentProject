import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class SupportTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> line = new LinkedList<>();

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add ticket");
        menu.add("Add urgent ticket");
        menu.add("Serve next ticket");
        menu.add("View waiting tickets");

        String banner = "Support Ticket";
        int width = 36;
        int leftover = width - banner.length();
        int leftpad = leftover / 2;
        int rightpad = leftover - leftpad;

        System.out.print("|");
        for (int i = 0; i < leftpad; i++) {
            System.out.print(" ");
        }

        System.out.print(banner);
        for (int i = 0; i < rightpad; i++) {
            System.out.print(" ");
        }

        System.out.println("|");

        System.out.println("How many actions?");
        int actions = Integer.parseInt(sc.nextLine());

        for (int round = 0; round < actions; round++) {

            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + " " + menu.get(i));
            }

            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("Enter a ticket");
                    String text = sc.nextLine();
                    line.add(text);
                    break;
                }
                case 2: {
                    System.out.println("Enter the urgent ticket: ");
                    String text = sc.nextLine();

                    Queue<String> newline = new LinkedList<>();
                    newline.add(text);

                    int oldSize = line.size();
                    for (int i = 0; i < oldSize; i++) {
                        newline.add(line.poll());
                    }
                    line = newline;
                    break;
                }
                case 3: {
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        String ticket = line.poll();
                        System.out.println("Serving: " + ticket);
                    }
                    break;
                }
                case 4: {
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        int size = line.size();
                        for (int i = 0; i < size; i++) {
                            String ticket = line.poll();
                            System.out.println((i + 1) + " " + ticket);
                            line.add(ticket);
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}