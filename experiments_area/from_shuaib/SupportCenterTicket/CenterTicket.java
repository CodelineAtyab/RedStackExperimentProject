import java.util.LinkedList;
import java.util.*;

public class CenterTicket{
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

        for(int i=0; i<menu.size(); i++){
            System.out.println((i+1) + " " + menu.get(i));
        }
    }
}